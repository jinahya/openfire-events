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

import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

/**
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
abstract class FileTransferEventWithTransfer extends FileTransferEvent {

    static <T extends FileTransferEventWithTransfer> T of(
            final Supplier<T> suppiler, final FileTransfer transfer) {
        if (suppiler == null) {
            throw new NullPointerException("supplier is null");
        }
        final T instance = suppiler.get();
        instance.setTransfer(
                ofNullable(transfer).map(FileTransferValue::of).orElse(null));
        return instance;
    }

    // -------------------------------------------------------------------------
    public FileTransferValue getTransfer() {
        return transfer;
    }

    public void setTransfer(final FileTransferValue transfer) {
        this.transfer = transfer;
    }

    // -------------------------------------------------------------------------
    private FileTransferValue transfer;
}
