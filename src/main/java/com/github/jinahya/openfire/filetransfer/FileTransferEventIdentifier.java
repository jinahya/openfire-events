package com.github.jinahya.openfire.filetransfer;

import com.github.jinahya.openfire.OpenfireEventIdentifier;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum FileTransferEventIdentifier implements OpenfireEventIdentifier<FileTransferEventIdentifier> {

    TRANSFER_START,

    TRANSFER_COMPLETE;
}
