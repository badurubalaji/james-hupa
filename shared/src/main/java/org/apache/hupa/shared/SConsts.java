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

package org.apache.hupa.shared;

public class SConsts {
    public static final String HUPA = "hupa/";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    public static final String SERVLET_DISPATCH = "dispatch";
>>>>>>> first commit
=======
    public static final String SERVLET_DISPATCH = "dispatch";
>>>>>>> first commit
=======
>>>>>>> remove both of gwt-representer and gwt-dispatch dependencies, add license headers to all new files
    public static final String SERVLET_DOWNLOAD = "downloadAttachmentServlet";
    public static final String SERVLET_UPLOAD = "uploadAttachmentServlet";
    public static final String SERVLET_SOURCE = "messageSourceServlet";

    
    public static final String PARAM_NAME = "name";
    public static final String PARAM_FOLDER = "folder";
    public static final String PARAM_UID = "uid";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public static final String PARAM_MODE = "mode";
    
    public static final String USER_SESS_ATTR = "user";
    public static final String CONTACTS_SESS_ATTR = "contacts";
    
    public static final String HEADER_IN_REPLY_TO = "In-Reply-To";
    public static final String HEADER_REFERENCES = "References";
    public static final String HEADER_MESSAGE_ID = "Message-ID";
    public static final String HEADER_REFERENCES_SEPARATOR = "\r\n ";
    
=======
    
    public static final String USER_SESS_ATTR = "user";
    public static final String CONTACTS_SESS_ATTR = "contacts";
>>>>>>> first commit
=======
=======
    public static final String PARAM_MODE = "mode";
>>>>>>> merged with main trunk in apache: replacing rounded borders with gwt decorator boxes, fix Hupa-93 Hupa-94, fix IE issue
    
    public static final String USER_SESS_ATTR = "user";
    public static final String CONTACTS_SESS_ATTR = "contacts";
<<<<<<< HEAD
>>>>>>> first commit
=======
    
    public static final String HEADER_IN_REPLY_TO = "In-Reply-To";
    public static final String HEADER_REFERENCES = "References";
    public static final String HEADER_MESSAGE_ID = "Message-ID";
    public static final String HEADER_REFERENCES_SEPARATOR = "\r\n ";
    
>>>>>>> Fixes HUPA-96 : pass reference ids when replying. Patch by Zsombor Gegesy
}