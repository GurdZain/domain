package com.kavli.core.xml.imp;

//import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.kavli.core.xml.XmlDoc;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDom implements XmlDoc {

	private Document document;

	public XmlDom() {
		init();
	}

	public void init() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createXml(Object obj, OutputStream ops) {

		Element xml = this.document.createElement("xml");
		this.document.appendChild(xml);

		/*
		 * for(int i=0;i<wcSendMsg.getMsgList().size();i++){
		 * System.out.println(wcSendMsg.getMsgList().get(i).getTitle());
		 * System.out.println(wcSendMsg.getMsgList().get(i).getTypeStr()); }
		 */
		/*
		 * Element ToUserName = this.document.createElement("ToUserName");
		 * ToUserName
		 * .appendChild(this.document.createCDATASection(wcMsg.getFromUserName
		 * ())); xml.appendChild(ToUserName);
		 * 
		 * Element FromUserName = this.document.createElement("FromUserName");
		 * FromUserName
		 * .appendChild(this.document.createCDATASection(wcMsg.getToUserName
		 * ())); xml.appendChild(FromUserName);
		 * 
		 * Element CreateTime = this.document.createElement("CreateTime");
		 * CreateTime.appendChild(this.document.createTextNode(new
		 * Date().getTime()/1000+"")); xml.appendChild(CreateTime);
		 * 
		 * Element MsgType = this.document.createElement("MsgType");
		 * MsgType.appendChild(this.document.createCDATASection("text"));
		 * xml.appendChild(MsgType);
		 * 
		 * Element Content = this.document.createElement("Content");
		 * Content.appendChild
		 * (this.document.createCDATASection("�㷢�͵���Ϣ�ǣ�"+wcMsg.getContent()));
		 * xml.appendChild(Content);
		 * 
		 * Element FuncFlag = this.document.createElement("FuncFlag");
		 * FuncFlag.appendChild(this.document.createTextNode("0"));
		 * xml.appendChild(FuncFlag);
		 */

		/*Element ToUserName = this.document.createElement("ToUserName");
		ToUserName.appendChild(this.document.createCDATASection(wcSendMsg
				.getToUserName()));
		xml.appendChild(ToUserName);

		Element FromUserName = this.document.createElement("FromUserName");
		FromUserName.appendChild(this.document.createCDATASection(wcSendMsg
				.getFromUserName()));
		xml.appendChild(FromUserName);

		Element CreateTime = this.document.createElement("CreateTime");
		CreateTime.appendChild(this.document.createTextNode(wcSendMsg
				.getCreateTime()
				+ ""));
		// System.out.println(wcSendMsg.getCreateTime()+"tttt");
		xml.appendChild(CreateTime);

		Element MsgType = this.document.createElement("MsgType");
		MsgType.appendChild(this.document.createCDATASection(wcSendMsg
				.getMsgTypeStr()));
		// System.out.println(wcSendMsg.getMsgTypeStr());
		xml.appendChild(MsgType);

		switch (wcSendMsg.getMsgType()) {
		case Msg.MSG_VAL_TEXT:
			Element Content = this.document.createElement("Content");
			if (wcSendMsg.getMsgList().size() > 0) {
				Content.appendChild(this.document.createCDATASection(wcSendMsg
						.getMsgList().get(0).getText()));
				// System.out.println(this.document.createCDATASection("������Ϣ���ݣ�"+wcSendMsg.getMsgList().get(0).getText()));
			} else {
				Content.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
			}
			xml.appendChild(Content);
			break;
		case Msg.MSG_VAL_IMAGE:
			if (wcSendMsg.getMsgList().size() > 0) {
				Element image = this.document.createElement("Image");
				xml.appendChild(image);

				Msg msg = wcSendMsg.getMsgList().get(0);
				// System.out.println(msg.getTitle()+" "+msg.getDescription()+" "+msg.getMusicUrl()+" "+msg.getHqMusicUrl());
				Element mediaId = this.document.createElement("MediaId");
				mediaId.appendChild(this.document.createCDATASection(msg
						.getMediaId()));
				image.appendChild(mediaId);
			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		case Msg.MSG_VAL_VOICE:
			if (wcSendMsg.getMsgList().size() > 0) {
				Element voice = this.document.createElement("Voice");
				xml.appendChild(voice);

				Msg msg = wcSendMsg.getMsgList().get(0);
				// System.out.println(msg.getTitle()+" "+msg.getDescription()+" "+msg.getMusicUrl()+" "+msg.getHqMusicUrl());
				Element mediaId = this.document.createElement("MediaId");
				mediaId.appendChild(this.document.createCDATASection(msg
						.getMediaId()));
				voice.appendChild(mediaId);
			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		case Msg.MSG_VAL_VIDEO:
			if (wcSendMsg.getMsgList().size() > 0) {
				Element video = this.document.createElement("Video");
				xml.appendChild(video);

				Msg msg = wcSendMsg.getMsgList().get(0);
				// System.out.println(msg.getTitle()+" "+msg.getDescription()+" "+msg.getMusicUrl()+" "+msg.getHqMusicUrl());
				Element mediaId = this.document.createElement("MediaId");
				mediaId.appendChild(this.document.createCDATASection(msg
						.getMediaId()));
				video.appendChild(mediaId);

				Element thumbMediaId = this.document
						.createElement("ThumbMediaId");
				mediaId.appendChild(this.document.createCDATASection(msg
						.getThumbMediaId()));
				video.appendChild(thumbMediaId);

			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		case Msg.MSG_VAL_MUSIC:
			if (wcSendMsg.getMsgList().size() > 0) {

				Element music = this.document.createElement("Music");
				xml.appendChild(music);

				Msg msg = wcSendMsg.getMsgList().get(0);
				// System.out.println(msg.getTitle()+" "+msg.getDescription()+" "+msg.getMusicUrl()+" "+msg.getHqMusicUrl());
				Element Title = this.document.createElement("Title");
				Title.appendChild(this.document.createCDATASection(msg
						.getTitle()));
				music.appendChild(Title);

				Element Description = this.document
						.createElement("Description");
				Description.appendChild(this.document.createCDATASection(msg
						.getDescription()));
				music.appendChild(Description);

				Element MusicUrl = this.document.createElement("MusicUrl");
				MusicUrl.appendChild(this.document.createCDATASection(msg
						.getMusicUrl()));
				music.appendChild(MusicUrl);

				Element HQMusicUrl = this.document.createElement("HQMusicUrl");
				HQMusicUrl.appendChild(this.document.createCDATASection(msg
						.getHqMusicUrl()));
				music.appendChild(HQMusicUrl);

				Element ThumbMediaId = this.document
						.createElement("ThumbMediaId");
				HQMusicUrl.appendChild(this.document.createCDATASection(msg
						.getThumbMediaId()));
				music.appendChild(ThumbMediaId);
			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		case Msg.MSG_VAL_NEWS:
			List<Msg> list = wcSendMsg.getMsgList();
			if (list.size() > 0) {
				int length = Math.min(list.size(), 10);
				Element ArticleCount = this.document
						.createElement("ArticleCount");
				ArticleCount.appendChild(this.document.createTextNode(length
						+ ""));
				xml.appendChild(ArticleCount);

				Element Articles = this.document.createElement("Articles");
				xml.appendChild(Articles);

				for (int i = 0; i < length; i++) {
					Msg msg = list.get(i);
					Element item = this.document.createElement("item");
					Articles.appendChild(item);

					Element Title = this.document.createElement("Title");
					Title.appendChild(this.document.createCDATASection(msg
							.getTitle()));
					item.appendChild(Title);

					Element Description = this.document
							.createElement("Description");
					if (msg.getDescription() != null) {
						Description.appendChild(this.document
								.createCDATASection(msg.getDescription()));
					}
					item.appendChild(Description);

					Element PicUrl = this.document.createElement("PicUrl");
					if (msg.getPicUrl() != null) {
						PicUrl.appendChild(this.document.createCDATASection(msg
								.getPicUrl()));
					}
					item.appendChild(PicUrl);

					Element Url = this.document.createElement("Url");
					if (msg.getUrl() != null) {
						Url.appendChild(this.document.createCDATASection(msg
								.getUrl()));
					}
					item.appendChild(Url);

				}
			} else {
				System.out.println("������Ϣʧ�ܣ�");
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		default:
			break;
		}
		Element FuncFlag = this.document.createElement("FuncFlag");
		FuncFlag.appendChild(this.document.createTextNode(wcSendMsg.getVipMsg()
				+ ""));
		xml.appendChild(FuncFlag);*/
		TransformerFactory tf = TransformerFactory.newInstance();

		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);

			OutputStreamWriter osw = new OutputStreamWriter(ops, "UTF-8");
			// transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			PrintWriter pw = new PrintWriter(osw);
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			osw.flush();
			ops.flush();
			osw.close();
			ops.close();
			// System.out.println("����XML�ļ��ɹ�!");
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	public void createXml(HashMap<String, String> data, OutputStream ops) {

		Element xml = this.document.createElement("xml");
		this.document.appendChild(xml);

		List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(
				data.entrySet());
		for (int i = 0; i < infoIds.size(); i++) {
			Map.Entry<String, String> item = infoIds.get(i);
			// System.out.println(item.getKey());
			if (item.getKey() != "") {
				Element element = this.document.createElement(item.getKey());
				element.appendChild(this.document.createCDATASection(item
						.getValue()));
				xml.appendChild(element);
			}
		}
		TransformerFactory tf = TransformerFactory.newInstance();

		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);

			OutputStreamWriter osw = new OutputStreamWriter(ops, "UTF-8");
			// transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			PrintWriter pw = new PrintWriter(osw);
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			osw.flush();
			ops.flush();
			osw.close();
			ops.close();
			// System.out.println("����XML�ļ��ɹ�!");
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	public void createXml(String fileName) {
		/*wcSendMsg = new WeChatSendMsg(Msg.MSG_VAL_NEWS);
		List<Msg> msgList = new ArrayList<Msg>();
		for (int i = 0; i < 2; i++) {
			Msg msg = new Msg();
			msg.setTitle("�����߱���-����");
			msg.setDescription("ҹ���˾���ʱ��");
			msg.setPicUrl("http://lzylzu.oicp.net/WebChatVerify/00+" + (i + 1)
					+ "+.jpg");
			msg.setUrl("http://www.qq.com");

			msg.setText("ewrerw");
			msgList.add(msg);
		}
		System.out.println(msgList.size());
		wcSendMsg.setFromUserName("steasdf");
		wcSendMsg.setToUserName("asdasdfa");
		wcSendMsg.setMsgList(msgList);
		Element xml = this.document.createElement("xml");
		this.document.appendChild(xml);
		System.out.println("test point 1");


		Element ToUserName = this.document.createElement("ToUserName");
		ToUserName.appendChild(this.document.createCDATASection(wcSendMsg
				.getToUserName()));
		xml.appendChild(ToUserName);

		Element FromUserName = this.document.createElement("FromUserName");
		FromUserName.appendChild(this.document.createCDATASection(wcSendMsg
				.getFromUserName()));
		xml.appendChild(FromUserName);

		Element CreateTime = this.document.createElement("CreateTime");
		CreateTime.appendChild(this.document.createTextNode(wcSendMsg
				.getCreateTime()
				+ ""));
		xml.appendChild(CreateTime);

		Element MsgType = this.document.createElement("MsgType");
		MsgType.appendChild(this.document.createCDATASection(wcSendMsg
				.getMsgTypeStr()));
		xml.appendChild(MsgType);
		System.out.println("test point 2");

		switch (wcSendMsg.getMsgType()) {
		case Msg.MSG_VAL_TEXT:
			Element Content = this.document.createElement("Content");
			if (wcSendMsg.getMsgList().size() > 0) {
				Content.appendChild(this.document.createCDATASection(wcSendMsg
						.getMsgList().get(0).getText()));
			} else {
				Content.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
			}
			xml.appendChild(Content);
			break;
		case Msg.MSG_VAL_MUSIC:
			if (wcSendMsg.getMsgList().size() > 0) {

				Element music = this.document.createElement("Music");
				xml.appendChild(music);

				Msg msg = wcSendMsg.getMsgList().get(0);
				System.out.println(msg.getTitle() + " " + msg.getDescription()
						+ " " + msg.getMusicUrl() + " " + msg.getHqMusicUrl());
				Element Title = this.document.createElement("Title");
				Title.appendChild(this.document.createCDATASection(msg
						.getTitle()));
				music.appendChild(Title);

				Element Description = this.document
						.createElement("Description");
				Description.appendChild(this.document.createCDATASection(msg
						.getDescription()));
				music.appendChild(Description);

				Element MusicUrl = this.document.createElement("MusicUrl");
				MusicUrl.appendChild(this.document.createCDATASection(msg
						.getMusicUrl()));
				music.appendChild(MusicUrl);

				Element HQMusicUrl = this.document.createElement("HQMusicUrl");
				HQMusicUrl.appendChild(this.document.createCDATASection(msg
						.getHqMusicUrl()));
				music.appendChild(HQMusicUrl);
			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		case Msg.MSG_VAL_NEWS:
			List<Msg> list = wcSendMsg.getMsgList();
			if (list.size() > 0) {
				int length = Math.min(list.size(), 10);
				Element ArticleCount = this.document
						.createElement("ArticleCount");
				ArticleCount.appendChild(this.document.createTextNode(length
						+ ""));
				xml.appendChild(ArticleCount);

				Element Articles = this.document.createElement("Articles");
				xml.appendChild(Articles);

				for (int i = 0; i < length; i++) {
					Msg msg = list.get(i);
					Element item = this.document.createElement("item");
					Articles.appendChild(item);

					Element Title = this.document.createElement("Title");
					Title.appendChild(this.document.createCDATASection(msg
							.getTitle()));
					item.appendChild(Title);

					Element Description = this.document
							.createElement("Description");
					// if(msg.getDescription()!=null)
					Description.appendChild(this.document
							.createCDATASection(msg.getDescription()));
					item.appendChild(Description);

					Element PicUrl = this.document.createElement("PicUrl");
					PicUrl.appendChild(this.document.createCDATASection(msg
							.getPicUrl()));
					item.appendChild(PicUrl);

					Element Url = this.document.createElement("Url");
					Url.appendChild(this.document.createCDATASection(msg
							.getUrl()));
					item.appendChild(Url);
				}
			} else {
				Element errorContent = this.document.createElement("Content");
				errorContent.appendChild(this.document
						.createCDATASection("������Ϣʧ�ܣ�������"));
				xml.appendChild(errorContent);
			}
			break;
		default:
			break;
		}

		Element FuncFlag = this.document.createElement("FuncFlag");
		FuncFlag.appendChild(this.document.createTextNode(wcSendMsg.getVipMsg()
				+ ""));
		xml.appendChild(FuncFlag);

		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			// transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			PrintWriter pw = new PrintWriter(fileName, "UTF-8");
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);

			// System.out.println("����XML�ļ��ɹ�!");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void parserXml(String fileName) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			NodeList employees = document.getChildNodes();
			for (int i = 0; i < employees.getLength(); i++) {
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				for (int j = 0; j < employeeInfo.getLength(); j++) {
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					for (int k = 0; k < employeeMeta.getLength(); k++) {
						System.out.println(employeeMeta.item(k).getNodeName()
								+ ":" + employeeMeta.item(k).getTextContent());
					}
				}
			}
			// System.out.println("�������");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}