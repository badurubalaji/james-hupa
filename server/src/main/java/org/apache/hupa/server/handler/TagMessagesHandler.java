/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.hupa.server.handler;

import java.util.ArrayList;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.logging.Log;
import org.apache.hupa.server.IMAPStoreCache;
import org.apache.hupa.shared.data.Tag;
import org.apache.hupa.shared.data.User;
import org.apache.hupa.shared.rpc.EmptyResult;
import org.apache.hupa.shared.rpc.TagMessage;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

/**
 * Handler which use user flags for supporting tagging of messages
 *
 */
public class TagMessagesHandler extends AbstractSessionHandler<TagMessage, EmptyResult>{

	@Inject
	public TagMessagesHandler(IMAPStoreCache cache, Log logger,
			Provider<HttpSession> sessionProvider) {
		super(cache, logger, sessionProvider);
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.hupa.server.handler.AbstractSessionHandler#executeInternal(org.apache.hupa.shared.rpc.Session, net.customware.gwt.dispatch.server.ExecutionContext)
	 */
	protected EmptyResult executeInternal(TagMessage action,
			ExecutionContext context) throws ActionException {
		User user = getUser(action.getSessionId());
		ArrayList<Long> uids = action.getMessageUids();
		Tag tag = action.getTag();
		try {
			IMAPStore store = cache.get(user);
			IMAPFolder folder = (IMAPFolder) store.getFolder(action.getFolder().getFullName());
			if (folder.isOpen() == false) {
				folder.open(Folder.READ_WRITE);
			}
			Message[] messages = folder.getMessagesByUID(copyUids(uids));
			for (int i = 0; i < messages.length; i++) {
				Message m = messages[i];
				m.getFlags().add(tag.toString());
			}
			folder.close(false);
			return new EmptyResult();
		} catch (MessagingException e) {
			logger.error("Error while tag messages " + uids.toString() + " for user " + user + " of folder" + action.getFolder(), e);
			throw new ActionException(e);
		}
	}

	private long[] copyUids(ArrayList<Long> uids) {
		long[] lArray = new long[uids.size()];
		for (int i = 0; i < uids.size(); i++) {
			lArray[i] = uids.get(i);
		}
		return lArray;
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.customware.gwt.dispatch.server.ActionHandler#getActionType()
	 */
	public Class<TagMessage> getActionType() {
		return TagMessage.class;
	}

}