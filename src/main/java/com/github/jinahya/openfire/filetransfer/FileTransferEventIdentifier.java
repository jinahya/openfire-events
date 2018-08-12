package com.github.jinahya.openfire.filetransfer;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

public enum FileTransferEventIdentifier implements OpenfireEventIdentifier<FileTransferEventIdentifier> {

    TRANSFER_START,

    TRANSFER_COMPLETE;
}
