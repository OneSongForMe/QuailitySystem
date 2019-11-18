var vm=new Vue({
	el:"#app",
	data: {
		members: [{}],
		mine: '',
		goods:[{"type":"","godsname":"","goodsid":"","shuliang":""}],
		keywords1:'',keywords2:'',keywords3:'',
		buydata:[{}],
		backdata:[{}],
		odata:[{}],
		forsee:[{}],
		userdata:[{}],
	},
	methods: {
		people:function(){
			var t=this;
			axios.post('showpeople')
			.then(function (res) {
				t.members=res.data;
				for( var i = 0; i < t.members.length; i++ ){
					t.members[i].joindata = timestampToTime(t.members[i].joindata);
				}
			});

		},
		self:function(){
			var t=this;
			axios.post('showself')
			.then(function (res) {
				t.mine=res.data;
			});
		},
		 edituser:function(item){
			 var t=this;
			 axios.get('adeduser', 
			{params:{id:item.id,username:item.username,userid:item.userid,password:item.password,job:item.job,number:item.number}})
			.then(function(res){
				t.mine=res.data;
			})
		 },
		 
		 deluser:function(item){
			 var t=this;
			 axios.get('deletuser', 
			{params:{id:item.id}})
			.then(function(res){
				t.mine=res.data;
			})
		 },
		 showgoods:function(){
			 var t=this;
				axios.get('allgoods')
				.then(function (res) {
					t.goods=res.data;
				});
		 },
		 
		 lookfor:function (keywords1,keywords2,keywords3) {
	            var newlist = [{}];
	            this.goods.forEach(function(item){
	                if((item.type.indexOf(keywords1) != -1)
	                    &&(item.goodsid.indexOf(keywords2) != -1)
	                    &&(item.godsname.indexOf(keywords3) != -1))
	                {
	                    newlist.push(item);
	                }
	            });
	            return newlist;
	        },
	        
	        showuserdata:function(){
	        	var t=this;
	        	axios.get('memberusedata')
	        	.then(function(res)
	        			{
	        		t.userdata=res.data;
	        		for( var i = 0; i < t.userdata.length; i++ ){
						t.userdata[i].usedata = timestampToTime(t.userdata[i].usedata);
					}
	        			});
	        },
	        
	        backg:function(){
	        	var t=this;
	        	var a=document.getElementById("btype").value;
	        	var b=document.getElementById("bname").value;
	        	var c=document.getElementById("bid").value;
	        	var d=document.getElementById("bnumber").value;
	        	var e=document.getElementById("bdata").value;
	        	axios.get('backgoods', 
	    		{params:{btype:a,bname:b,bid:c,bnumber:d,bdata:e}})
	    		.then(function(res){
	    			t.backdata=res.data;
	    			for( var i = 0; i < t.backdata.length; i++ ){
						t.backdata[i].backdata = timestampToTime(t.backdata[i].backdata);
					}
	    		});
	        },
	        addo:function(){
	        	var t=this;
	        	var a=document.getElementById("oname").value;
	        	var b=document.getElementById("odata").value;
	        	var c=document.getElementById("onumber").value;
	        	var d=document.getElementById("oplace").value;
	        	axios.get('addorder',
	        	{params:{oname:a,odata:b,onumber:c,oplace:d}})
	        	.then(function(res){
	        		t.odata=res.data;
	        		for( var i = 0; i < t.odata.length; i++ ){
						t.odata[i].orderdate = timestampToTime(t.odata[i].orderdate);
					}
	        	});
	        },
	        forest:function(){
	        	var c=document.getElementById("onumber").value;
	        	var s=Number(c);
	        	var t=this;
	        	t.forsee[0]={type:"胶料",name:"白胶",number:s*0.5+"kg"};
	        	t.forsee[1]={type:"包装盒",name:"小盒子",number:s*1+"个"};
	        	t.forsee[2]={type:"布料",name:"黑布",number:s*0.4+"米"};
	        	t.forsee[3]={type:"线头",name:"黑线",number:s*0.06+"筒"};
	        },
	        
	        buy:function(){
	        	var t=this;
	        	var a=document.getElementById("gtype").value;
	        	var b=document.getElementById("gname").value;
	        	var c=document.getElementById("gid").value;
	        	var d=document.getElementById("gsource").value;
	        	var e=document.getElementById("gnumber").value;
	        	var f=document.getElementById("gsender").value;
	        	var g=document.getElementById("gdata").value;
				 axios.get('buygoods', 
				{params:{gtype:a,gname:b,gid:c,gsource:d,gnumber:e,gsender:f,gdata:g}})
				.then(function(res){
					t.buydata=res.data;
					for( var i = 0; i < t.buydata.length; i++ ){
						t.buydata[i].indate = timestampToTime(t.buydata[i].indate);
					}
				});
	        },
	        
	        dusedata:function(item){
	        	axios.get('duserdata', 
	        			{params:{id:item.id}})
	        			.then(function(res){
	        				t.userdata=res.data;
	    	        		for( var i = 0; i < t.userdata.length; i++ ){
	    						t.userdata[i].usedata = timestampToTime(t.userdata[i].usedata);
	    					}
	        			})
	        },
	        

	}
	
});

function timestampToTime(timestamp) {
	   var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
	   Y = date.getFullYear() + '-';
	   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	   D = date.getDate() + ' ';
	   h = date.getHours() + ':';
	   m = date.getMinutes() + ':';
	   s = date.getSeconds();
	   return Y+M+D;
}

