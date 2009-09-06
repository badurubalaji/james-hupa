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

import javax.mail.Folder;
import javax.mail.MessagingException;

import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.hupa.server.mock.MockIMAPFolder;
import org.apache.hupa.server.mock.MockIMAPStore;
import org.apache.hupa.server.mock.MockLog;
import org.apache.hupa.shared.data.IMAPFolder;
import org.apache.hupa.shared.data.User;
import org.apache.hupa.shared.exception.InvalidSessionException;
import org.apache.hupa.shared.rpc.CreateFolder;

public class CreateFolderHandlerTest extends AbstractHandlerTest{

	
	public void testCreate() throws MessagingException {
		User user = createUser();

		session.setAttribute("user", user);
		storeCache.addValidUser(user.getName(),user.getPassword());
		IMAPFolder folder = createFolder();
		MockIMAPStore store = (MockIMAPStore) storeCache.get(user);
		Folder f1 = store.getFolder(folder.getFullName());
		assertFalse("not exists",f1.exists());
		
		CreateFolderHandler handler = new CreateFolderHandler(storeCache,new MockLog(),sessionProvider);
		try {
			handler.execute(new CreateFolder(user.getSessionId(),folder), null);
			Folder f = store.getFolder(folder.getFullName());
			assertTrue("exists",f.exists());
			
		} catch (ActionException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	
	public void testDuplicateFolder() throws MessagingException {
		User user = createUser();

		session.setAttribute("user", user);
		storeCache.addValidUser(user.getName(),user.getPassword());
		IMAPFolder folder = createFolder();
		MockIMAPStore store = (MockIMAPStore) storeCache.get(user);
		Folder f1 = store.getFolder(folder.getFullName());
		
		f1.create(Folder.HOLDS_FOLDERS);

		CreateFolderHandler handler = new CreateFolderHandler(storeCache,new MockLog(),sessionProvider);
		try {
			handler.execute(new CreateFolder(user.getSessionId(),folder), null);
			fail("Folder already exists");
		} catch (ActionException e) {
			// folder already exists
			e.printStackTrace();
		}
		
	}
	
	public void testInvalidSessionId() {
		User user = createUser();
		user.setSessionId("INVALID");
		IMAPFolder folder = createFolder();
		CreateFolderHandler handler = new CreateFolderHandler(storeCache,new MockLog(),sessionProvider);
		try {
			handler.execute(new CreateFolder(user.getSessionId(),folder), null);
			fail("Invalid session");
			
		} catch (InvalidSessionException e) {
			e.printStackTrace();
		} catch (ActionException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	private IMAPFolder createFolder() {
		IMAPFolder folder = new IMAPFolder();
		folder.setFullName("NewFolder");
		folder.setDelimiter(String.valueOf(MockIMAPFolder.SEPERATOR));
		return folder;
	}
}