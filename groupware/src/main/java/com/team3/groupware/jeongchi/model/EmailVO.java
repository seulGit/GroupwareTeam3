package com.team3.groupware.jeongchi.model;


public class EmailVO {
		private String message_sender;
		private String senderMail;
		private String message_receiver;
		private String message_title;
		private String message_contents;
		
		public String getMessage_sender() {
			return message_sender;
		}
		public void setMessage_senderName(String message_sender) {
			this.message_sender = message_sender;
		}
		public String getSenderMail() {
			return senderMail;
		}
		public void setSenderMail(String senderMail) {
			this.senderMail = senderMail;
		}
		public String getMessage_receiver() {
			return message_receiver;
		}
		public void setMessage_receiver(String message_receiver) {
			this.message_receiver = message_receiver;
		}
		public String getMessage_title() {
			return message_title;
		}
		public void setMessage_title(String message_title) {
			this.message_title = message_title;
		}

		public String getMessage_contents() {
			return message_contents;
		}
		public void setMessage_contents(String message_contents) {
			this.message_contents = message_contents;
		}
		@Override
		public String toString() {
			return "EmailVO [message_sender=" + message_sender + ", senderMail=" + senderMail + ", message_receiver="
					+ message_receiver + ", message_title=" + message_title + ", message_contents=" + message_contents
					+ "]";
		}		
	}
