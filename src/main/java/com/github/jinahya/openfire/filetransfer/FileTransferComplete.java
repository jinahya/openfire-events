/*
 * Copyright 2018 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.openfire.filetransfer;

import org.jivesoftware.openfire.filetransfer.FileTransfer;
import org.jivesoftware.openfire.filetransfer.FileTransferEventListener;

/**
 * An event for {@link FileTransferEventListener#fileTransferComplete(FileTransfer, boolean)}.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class FileTransferComplete extends FileTransferEventWithTransferAndFlag {

    // -----------------------------------------------------------------------------------------------------------------
    public static FileTransferComplete of(final FileTransfer transfer, final boolean successful) {
        final FileTransferComplete instance = of(FileTransferComplete::new, transfer, successful);
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public FileTransferComplete() {
        super(FileTransferEventIdentifier.TRANSFER_COMPLETE);
    }

    // ------------------------------------------------------------------------------------------------------ successful
    public boolean getSuccessful() {
        return getFlag();
    }

    void setSuccessful(final boolean successful) {
        setFlag(successful);
    }
}
