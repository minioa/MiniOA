package org.minioa.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

public class UserTree implements org.richfaces.event.NodeSelectedListener{
	/**
	 * 作者：daiqianjie 网址：www.minioa.net 创建日期：2011-11-05
	 */
	public MySession mySession;

	public MySession getMySession() {
		if (mySession == null)
			mySession = (MySession) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MySession");
		if(null == mySession)
			return null;
		if(!"true".equals(mySession.getIsLogin()))
			return null;
		return mySession;
	}

	private TreeNode<User> rootNode = null;

	private String nodeTitle;
	private static final String DATA_PATH = FunctionLib.getBaseDir() + "user.properties";

	private void addNodes(String path, TreeNode<User> node, Properties properties) {
		boolean end = false;
		int counter = 1;
		while (!end) {
			String key = path != null ? path + '.' + counter : String.valueOf(counter);
			String value = properties.getProperty(key);
			if (value != null) {
				String[] arr = value.split("\\,");
				TreeNodeImpl<User> nodeImpl = new TreeNodeImpl<User>();
				nodeImpl.setData(new User(arr[0], Integer.valueOf(arr[1]), arr[2]));
				node.addChild(new Integer(counter), nodeImpl);
				addNodes(key, nodeImpl, properties);
				counter++;
			} else {
				end = true;
			}
		}
	}

	private void loadTree() {
		try {
			File f = new File(DATA_PATH);
			if (f.exists()) {
				InputStream is = new FileInputStream(DATA_PATH);
				Properties property = new Properties();
				property.load(is);
				rootNode = new TreeNodeImpl<User>();
				addNodes(null, rootNode, property);
			}
		} catch (IOException e) {
			throw new FacesException(e.getMessage(), e);
		}
	}

	public void processSelection(NodeSelectedEvent event) {
		try {
			HtmlTree tree = (HtmlTree) event.getComponent();
			User bean = (User) tree.getRowData();
			if (bean.getType().equals("user")) {
				getMySession().getTempInt().put("UserTree.id", bean.getID_());
				//System.out.println("usertree:" + bean.getID_());
				getMySession().getTempStr().put("UserTree.displayName", bean.getDisplayName());
			} else {
				getMySession().getTempInt().put("UserTree.id", 0);
				getMySession().getTempStr().put("UserTree.displayName", "");
			}
			//System.out.println("agentId11:" + getMySession().getTempInt().get("UserTree.id"));
		} catch (Exception e) {
			throw new FacesException(e.getMessage(), e);
		}
	}

	public TreeNode<User> getTreeNode() {
		if (rootNode == null) {
			loadTree();
		}
		return rootNode;
	}

	public String getNodeTitle() {
		return nodeTitle;
	}

	public void setNodeTitle(String nodeTitle) {
		this.nodeTitle = nodeTitle;
	}
}