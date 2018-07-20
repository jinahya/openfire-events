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

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class FileTransferComplete {

    public FileTransfer getTransfer() {
        return transfer;
    }

    public boolean isSuccessful() {
        return successful;
    }

    private FileTransfer transfer;

    private boolean successful;
}
