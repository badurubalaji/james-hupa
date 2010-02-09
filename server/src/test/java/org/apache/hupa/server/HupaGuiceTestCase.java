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


package org.apache.hupa.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import com.sun.mail.imap.IMAPStore;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.hupa.server.guice.GuiceTestModule;
import org.apache.hupa.server.handler.AbstractSendMessageHandler;
import org.apache.hupa.server.handler.ContactsHandler;
import org.apache.hupa.server.handler.CreateFolderHandler;
import org.apache.hupa.server.handler.DeleteFolderHandler;
import org.apache.hupa.server.handler.FetchFoldersHandler;
import org.apache.hupa.server.handler.FetchMessagesHandler;
import org.apache.hupa.server.handler.ForwardMessageHandler;
import org.apache.hupa.server.handler.GetMessageDetailsHandler;
import org.apache.hupa.server.handler.LoginUserHandler;
import org.apache.hupa.server.handler.ReplyMessageHandler;
import org.apache.hupa.server.handler.SendMessageHandler;
import org.apache.hupa.server.preferences.UserPreferencesStorage;
import org.apache.hupa.shared.data.User;
import org.apache.hupa.shared.rpc.SendMessage;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

public abstract class HupaGuiceTestCase extends TestCase {

    protected Injector injector = Guice.createInjector(getModule());

    protected HttpSession httpSession = injector.getInstance(HttpSession.class);
    
    protected AbstractSendMessageHandler<SendMessage> abstSendMsgHndl = injector.getInstance(SendMessageHandler.class);
    
    protected ContactsHandler contactsHandler = injector.getInstance(ContactsHandler.class);

    protected CreateFolderHandler createFHandler = injector.getInstance(CreateFolderHandler.class);
    
    protected DeleteFolderHandler deleteFHandler = injector.getInstance(DeleteFolderHandler.class);
    
    protected FetchFoldersHandler fetchFHandler = injector.getInstance(FetchFoldersHandler.class);
    
    protected FetchMessagesHandler fetchMessagesHandler = injector.getInstance(FetchMessagesHandler.class);
    
    protected ForwardMessageHandler fwdMsgHndl = injector.getInstance(ForwardMessageHandler.class);
    
    protected GetMessageDetailsHandler getDetailsMsgHndl = injector.getInstance(GetMessageDetailsHandler.class);
    
    protected Log logger = injector.getInstance(Log.class);
    
    protected LoginUserHandler loginUser = injector.getInstance(LoginUserHandler.class);
    
    protected ReplyMessageHandler reMsgHndl = injector.getInstance(ReplyMessageHandler.class);
    
    protected Session session = injector.getInstance(Session.class);
    
    protected IMAPStoreCache storeCache = injector.getInstance(IMAPStoreCache.class);
    
    protected  User testUser;
    
    protected UserPreferencesStorage userPreferences = injector.getInstance(UserPreferencesStorage.class);
    
    protected IMAPStore store;
    
    public HupaGuiceTestCase() {
        try {
            testUser = injector.getInstance(User.class);
            store = storeCache.get(testUser);
            httpSession.setAttribute("user", testUser);
        } catch (Exception e) {
        }
    }
    
    protected Module getModule() {
        return new GuiceTestModule();
    }
}
