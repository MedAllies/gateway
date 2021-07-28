package org.nhindirect.gateway.streams;

import org.nhindirect.common.mail.SMTPMailMessage;
import org.nhindirect.common.mail.streams.SMTPMailMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class STAPostProcessSource
{
	// Maps to the Spring Cloud Stream functional output binding name.
	protected static final String OUT_BINDING_NAME = "direct-sta-post-process-out-0";
	
	@Autowired
	private StreamBridge streamBridge;
	
	public <T> void staPostProcess(SMTPMailMessage msg) 
	{
		streamBridge.send(OUT_BINDING_NAME, SMTPMailMessageConverter.toStreamMessage(msg));
	}
}
