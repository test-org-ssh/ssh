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
	private int tieid; //传过来的帖子id   还有评论时传过来的帖子id
	private int tieindex;//或缺帖子的index
	
	private String commentcontent;//获取评论时传过来的评论内容
	private String replycontent;//回复传过来的内容
	private int commentindex; //传过来回复的评论的index 通过集合获取评论
	private int isAgree; //传过来关于点赞 或取消赞的参数
	private int toAgreeid;//取消赞时 需要通过赞对象的id来删除
	private int updateAn;// 是否改变赞的数目 0减一 1加一

	Map<String,Object> returndata=new HashMap<String,Object>();//返回给页面的json
	private CommentManager commentmanager;
	private ReplyManager replymanager;
	private TieManager tiemanager;
	private AgreeManager agreemanager;
	
	
	//访问getNoteDetail 通过tieid
	public String getNoteDetailexecute() {
		ActionContext ac = ActionContext.getContext();
		System.out.println(tieid);
		
		//获取当前登录的用户     ----------------T
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
		ac.getSession().put("replylist",replylist); //存入session域中
		ac.getSession().put("postTie", postTie);
		ac.getSession().put("myself", myself);
		
		return "success";
	}
	
	//处理提交来的新评论
	public String commitNewComment() {
		ActionContext ac = ActionContext.getContext();
		PostTie postTie = (PostTie)ac.getSession().get("postTie");
		//PostTie postTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
		
		
		int res = commentmanager.InsertNewComment((User)ac.getSession().get("myself"),(PostTie)ac.getSession().get("postTie"),commentcontent);
		//同时更新帖子的评论条数
		int flag=tiemanager.updateCommentNumToTie(postTie);
		postTie.setCommentNum(postTie.getCommentNum()+1);
		ac.getSession().put("postTie",postTie);
		System.out.println("帖子的评论数增加一");
		
		
		returndata.put("status",res);   //返回0表示操作成功
		returndata.put("success", true);
		return "success";
	} 
		//处理提交来的新回复
		public String commitReply() {
			ActionContext ac = ActionContext.getContext();
			Comment replyToCom = ((ArrayList<Comment>)ac.getSession().get("commentlist")).get(commentindex);
			User replyFromUser = (User)ac.getSession().get("myself");
			User replyToUser = replyToCom.getUser();
			PostTie replyToTie = (PostTie)ac.getSession().get("postTie");
			//PostTie replyToTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
			
			int res=-1;//对ajax返回失败标志
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
		
		//处理点赞或取消赞请求
		public String commitAgree() {
			ActionContext ac = ActionContext.getContext();
			PostTie postTie = (PostTie)ac.getSession().get("postTie");
			//PostTie postTie = (PostTie) ((ArrayList<PostTie>)ac.getSession().get("postTieList")).get(tieindex);
			User myself = (User)ac.getSession().get("myself");
			int res=2; //操作失败
			if(isAgree == 1) {  //点赞
				res=agreemanager.insertNewAgreeByTieAndUser(postTie,myself); //返回的是agreeid
				
			}else if(isAgree == 0) {//取消赞
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
			//同时更新帖子的点赞数
			if(updateAn == 0) {
				updateAn = -1;
			}
			
			postTie.setAgreeNum(postTie.getAgreeNum()+updateAn);
			int flag=tiemanager.updateAgreeNumToTie(postTie); //0表示操作成功
			ac.getSession().put("postTie",postTie);
			System.out.println("帖子的评论数增加一");
			
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
