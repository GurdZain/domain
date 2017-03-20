package com.nnbee.core.util;
/**
 *=====================================================================
 * ACP JMS messaging Message ID Generator 
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */	 

import java.util.UUID;

public class MessageIdGenerator {
	
	/**
	 * Generate a unique string using for JMS message id.
	 * @return
	 */
	public static String generateUniqueMessageId(){
		UUID messageId = UUID.randomUUID();
		return messageId.toString();
	}

}
