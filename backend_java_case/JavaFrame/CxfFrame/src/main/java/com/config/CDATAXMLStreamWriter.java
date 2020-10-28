package com.config;

/**
 * @author yangzl 2020.10.28
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @history:
 */

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

public class CDATAXMLStreamWriter extends DelegatingXMLStreamWriter {

    private String currentElementName;

    public CDATAXMLStreamWriter(XMLStreamWriter writer) {
        super(writer);
    }

    @Override
    public void writeCharacters(String text) throws XMLStreamException {
        boolean useCData = isNeedCData(text);
        if (useCData) {
            super.writeCData(text);
        } else {
            super.writeCharacters(text);
        }
    }

    private boolean isNeedCData(String text) {
        // 鑷繁鎷撳睍鍝簺灞炴?ч渶瑕佸鐞咰DATA
        if(text != null && !"".equals(text)){

            if(text.startsWith("MSH")){

                return true;
            }
        }

        return false;
    }

    public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
        currentElementName = local;
        super.writeStartElement(prefix, local, uri);
    }
}
