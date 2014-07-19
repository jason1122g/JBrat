package org.jbrat.tool

import groovy.transform.CompileStatic


@CompileStatic
class FileTool {

    static void recursiveCopy(File fSource, File fDest) {
        if (fSource.isDirectory()) {
            if (!fDest.exists()) {
                fDest.mkdirs();
            }

            String[] fList = fSource.list();

            for (int index = 0; index < fList.length; index++) {
                File dest   = new File(fDest  , fList[index]);
                File source = new File(fSource, fList[index]);

                recursiveCopy(source, dest);
            }
        }
        else {

            FileInputStream fInStream   = new FileInputStream(fSource);
            FileOutputStream fOutStream = new FileOutputStream(fDest);

            byte[] buffer = new byte[2048];
            int iBytesReads;

            while ((iBytesReads = fInStream.read(buffer)) >= 0) {
                fOutStream.write(buffer, 0, iBytesReads);
            }

            if (fInStream != null) {
                fInStream.close();
            }

            if (fOutStream != null) {
                fOutStream.close();
            }
        }
    }
}
