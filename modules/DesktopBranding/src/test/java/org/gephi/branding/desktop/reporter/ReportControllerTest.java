/*
Copyright 2008-2021 Gephi
Authors : Antonin Delpeuch <antonin@delpeuch.eu>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
*/

package org.gephi.branding.desktop.reporter;

import org.junit.Test;
import org.junit.Assert;

public class ReportControllerTest {

    @Test
    public void testAnonymizeUnixLog() {
        String log = "" +
                "  System Locale; Encoding = en_GB (gephi); UTF-8\n" +
                "  Home Directory          = /home/mjackson\n" +
                "  Current Directory       = /home/mjackson/gephi/modules/application\n" +
                "  User Directory          = /home/mjackson/gephi/modules/application";

        String expected = "" +
                "  System Locale; Encoding = en_GB (gephi); UTF-8\n" +
                "  Home Directory          = /ANONYMIZED_HOME_DIR\n" +
                "  Current Directory       = /ANONYMIZED_HOME_DIR/gephi/modules/application\n" +
                "  User Directory          = /ANONYMIZED_HOME_DIR/gephi/modules/application";

        String anonymized = ReportController.anonymizeLog(log);

        Assert.assertEquals(expected, anonymized);
    }

    @Test
    public void testAnonymizeWindowsLog() {
        String log = "" +
                "  Java Home               = C:\\Program Files\\Java\\jre1.8.0_311\n" +
                "  System Locale; Encoding = en_US (gephi); Cp1254\n" +
                "  Home Directory          = C:\\Users\\RickAstley\n" +
                "  Current Directory       = C:\\Program Files\\Gephi-0.9.2\n" +
                "  User Directory          = C:\\Users\\RickAstley\\AppData\\Roaming\\.gephi\\0.9.2\\dev\n" +
                "  Cache Directory         = C:\\Users\\RickAstley\\AppData\\Roaming\\.gephi\\0.9.2\\dev\\var\\cache\n" +
                "  Installation            = C:\\Program Files\\Gephi-0.9.2\\platform";

        String expected = "" +
                "  Java Home               = C:\\Program Files\\Java\\jre1.8.0_311\n" +
                "  System Locale; Encoding = en_US (gephi); Cp1254\n" +
                "  Home Directory          = C:/ANONYMIZED_HOME_DIR\n" +
                "  Current Directory       = C:\\Program Files\\Gephi-0.9.2\n" +
                "  User Directory          = C:/ANONYMIZED_HOME_DIR\\AppData\\Roaming\\.gephi\\0.9.2\\dev\n" +
                "  Cache Directory         = C:/ANONYMIZED_HOME_DIR\\AppData\\Roaming\\.gephi\\0.9.2\\dev\\var\\cache\n" +
                "  Installation            = C:\\Program Files\\Gephi-0.9.2\\platform";
        String anonymized = ReportController.anonymizeLog(log);

        Assert.assertEquals(expected, anonymized);
    }
}