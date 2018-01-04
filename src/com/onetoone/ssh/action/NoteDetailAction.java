package com.onetoone.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onetoone.ssh.service.AgreeManager;
import com.onetoone.ssh.service.CommentManager;
import com.onetoone.ssh.entity.Agree;
import com.onetoone.ssh.entity.Comment;
import com.onetoone.ssh.entity.PostTie;
import com.onetoone.ssh.entity.Reply;
import com.onetoone.ssh.entity.User;
import com.onetoone.ssh.service.ReplyManager;
import com.onetoone.ssh.service.TieManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoteDetailAction extends ActionSupport {
	private int tieid; //������������id   ��������ʱ������������id
	private int tieindex;//��ȱ���ӵ�index
	
	private String commentcontent;//��ȡ����ʱ����������������
	private String replycontent;//�ظ�������������
	private int commentindex; //�������ظ������۵�index ͨ�����ϻ�ȡ����
	private int isAgree; //���������ڵ��� ��ȡ���޵Ĳ���
	private int toAgreeid;//ȡ����ʱ ��Ҫͨ���޶����id��ɾ��
	private int updateAn;// �Ƿ�ı��޵���Ŀ 0��һ 1��һ

	Map<String,Object> returndata=new HashMap<String,Object>();//���ظ�ҳ���json
	private CommentManager commentmanager;
	private ReplyManager replymanager;
	private TieManager tiemanager;
	private AgreeManager agreemanager;
	
	
	//����getNoteDetail ͨ��tieid
	public String getNoteDetailexecute() {
		ActionContext ac = ActionContext.getContext();
		System.out.println(tieid);
		
		//��ȡ��ǰ��¼���û�     ----------------T
		User myself = (User)ac.getSession().get("myself");
//	
//		
		List<PostTie> ptlist = ((ArrayList<PostTie>)ac.getSession().get("postTieList"));
		if (ptlist == null){
			ptlist = new ArrayList<PostTie>();
		}
		PostTie postTie = new PostTie();
		for (int i=0; i<ptlist.size(); i++){
			if (tieid == ptlist.get(i).getId()){
				postTie = ptlist.get(i);
				System.out.println(postTie.getAgreeNum()+"99999999");
			}
		}
		
		List<Comment> commentlist = commentmanager.getAllComment(tieid);
		List<Reply> replylist = replymanager.getALLReply(tieid);
		Agree agree = agreemanager.getAgreeByTieIdAndUserId(tieid,myself.getId());
		ac.getSession().put("agreeobject",agree);
		ac.getSession().put("commentlist",commentlist);
		ac.getSession().put("replylist",replylist); //����session����
		ac.getSession().put("postTie", postTie);
		ac.getSession().put("myself", myself);
		
		return "success";
	}
	
	//�����ύ����������
	public String commitNewComment() {
		ActionContext ac = ActionContext.getContext();
		PostTie postTie = (PostTie)ac.getSession().get("postTie");
		//PostTie postTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
		
		
		int res = commentmanager.InsertNewComment((User)ac.getSession().get("myself"),(PostTie)ac.getSession().get("postTie"),commentcontent);
		//ͬʱ�������ӵ���������
		int flag=tiemanager.updateCommentNumToTie(postTie);
		postTie.setCommentNum(postTie.getCommentNum()+1);
		ac.getSession().put("postTie",postTie);
		System.out.println("���ӵ�����������һ");
		
		
		returndata.put("status",res);   //����0��ʾ�����ɹ�
		returndata.put("success", true);
		return "success";
	} 
		//�����ύ�����»ظ�
		public String commitReply() {
			ActionContext ac = ActionContext.getContext();
			Comment replyToCom = ((ArrayList<Comment>)ac.getSession().get("commentlist")).get(commentindex);
			User replyFromUser = (User)ac.getSession().get("myself");
			User replyToUser = replyToCom.getUser();
			PostTie replyToTie = (PostTie)ac.getSession().get("postTie");
			//PostTie replyToTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
			
			int res=-1;//��ajax����ʧ�ܱ�־
			if(replyFromUser == null) {
				System.out.println("+++++++111111");
			}
			if(replyToCom == null) {
				System.out.println("+++++++222222");
			}
			
			if(replyToUser == null) {
				System.out.println("+++++++333333");
			}
			if(replyToTie == null) {
				System.out.println("+++++++444444");
			}
			if(replycontent==null || replycontent.equals("")) {
				System.out.println("+++++++555555"+replycontent+"++++++"+commentindex);
			}
			if(replyFromUser != null && replyToUser != null && replyToTie!= null && replyToCom!= null && !replycontent.equals("") && replycontent != null) {
				 res = replymanager.InsertNewReply(replyFromUser,replyToUser,replyToTie,replyToCom,replycontent);
				 
			}
			returndata.put("status",res);  
			returndata.put("success", true);
			return "success";
		} 
		
		//������޻�ȡ��������
		public String commitAgree() {
			ActionContext ac = ActionContext.getContext();
			PostTie postTie = (PostTie)ac.getSession().get("postTie");
			//PostTie postTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
			User myself = (User)ac.getSession().get("myself");
			int res=2; //����ʧ��
			if(isAgree == 1) {  //����
				res=agreemanager.insertNewAgreeByTieAndUser(postTie,myself); //���ص���agreeid
				
			}else if(isAgree == 0) {//ȡ����
				res=agreemanager.deleteAgreeById(toAgreeid);
			}
				
			returndata.put("status",res);  
			returndata.put("success", true);
			return "success";
		}
		public String updateAgreeNum() {
			ActionContext ac = ActionContext.getContext();
			PostTie postTie = (PostTie)ac.getSession().get("postTie");
			//PostTie postTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
			//ͬʱ�������ӵĵ�����
			if(updateAn == 0) {
				updateAn = -1;
			}
			
			postTie.setAgreeNum(postTie.getAgreeNum()+updateAn);
			int flag=tiemanager.updateAgreeNumToTie(postTie); //0��ʾ�����ɹ�
			ac.getSession().put("postTie",postTie);
			System.out.println("���ӵ�����������һ");
			
			returndata.put("status",flag);  
			returndata.put("success", true);
			return "success";
		}
		
		public AgreeManager getAgreemanager() {
			return agreemanager;
		}
		public void setAgreemanager(AgreeManager agreemanager) {
			this.agreemanager = agreemanager;
		}
		public CommentManager getCommentmanager() {
			return commentmanager;
		}
		public void setCommentmanager(CommentManager commentmanager) {
			this.commentmanager = commentmanager;
		}
		public ReplyManager getReplymanager() {
			return replymanager;
		}
		public void setReplymanager(ReplyManager replymanager) {
			this.replymanager = replymanager;
		}
		
		
		public Map<String, Object> getReturndata() {
			return returndata;
		}
	
		public void setReturndata(Map<String, Object> returndata) {
			this.returndata = returndata;
		}
		
		public int getTieid() {
			return tieid;
		}
		public void setTieid(int tieid) {
			this.tieid = tieid;
		}
	
		
		public String getCommentcontent() {
			return commentcontent;
		}
		public void setCommentcontent(String commentcontent) {
			this.commentcontent = commentcontent;
		}
		public String getReplycontent() {
			return replycontent;
		}
		public void setReplycontent(String replycontent) {
			this.replycontent = replycontent;
		}
		public int getCommentindex() {
			return commentindex;
		}
		public void setCommentindex(int commentindex) {
			this.commentindex = commentindex;
		}
		public TieManager getTiemanager() {
			return tiemanager;
		}
		public void setTiemanager(TieManager tiemanager) {
			this.tiemanager = tiemanager;
		}
		public int getIsAgree() {
			return isAgree;
		}
		public void setIsAgree(int isAgree) {
			this.isAgree = isAgree;
		}
		public int getToAgreeid() {
			return toAgreeid;
		}
		public void setToAgreeid(int toAgreeid) {
			this.toAgreeid = toAgreeid;
		}
		public int getUpdateAn() {
			return updateAn;
		}
		public void setUpdateAn(int updateAn) {
			this.updateAn = updateAn;
		}
		public int getTieindex() {
			return tieindex;
		}

		public void setTieindex(int tieindex) {
			this.tieindex = tieindex;
		}
		
}
