<<<<<<< HEAD
<<<<<<< HEAD
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

package org.apache.hupa.client.ui;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;

public interface AppLayout {
	DockLayoutPanel getAppLayoutPanel();
	AcceptsOneWidget getNorthContainer();
	AcceptsOneWidget getWestContainer();
	AcceptsOneWidget getCenterContainer();
	void setLoginLayout();
	void setDefaultLayout();
=======
package org.apache.hupa.client.ui;
=======
package org.apache.hupa.client.ui;

>>>>>>> Change to new mvp framework - first step

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.LayoutPanel;

public interface AppLayout {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Change to new mvp framework - first step

  LayoutPanel getMainLayoutPanel();

  AcceptsOneWidget getWestContainer();

  AcceptsOneWidget getMainContainer();

  void setLoginLayout();

  void setDefaultLayout();

<<<<<<< HEAD
>>>>>>> Change to new mvp framework - first step
=======
	LayoutPanel getMainLayoutPanel();
	AcceptsOneWidget getTopContainer();
	AcceptsOneWidget getWestContainer();
	AcceptsOneWidget getMainContainer();
	void setLoginLayout();
	void setDefaultLayout();
>>>>>>> introduce the top activity
=======
>>>>>>> Change to new mvp framework - first step
}
