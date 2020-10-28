package com.config;

import java.io.OutputStream;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;

/**
 * @author yangzl 2020.10.28
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @history:
 */
public class CDATAOutInterceptor {

    public CDATAOutInterceptor() {
        super(Phase.WRITE);
    }

    public void handleMessage(Message message) {
        message.put("disable.outputstream.optimization", Boolean.TRUE);
        XMLStreamWriter writer = StaxUtils.createXMLStreamWriter(message.getContent(OutputStream.class));
        message.setContent(XMLStreamWriter.class, new CDATAXMLStreamWriter(writer));
    }
}
