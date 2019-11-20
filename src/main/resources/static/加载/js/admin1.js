
Vue.filter('subDate',function(date){
	var dt = new Date(date);
	var y = dt.getFullYear();
	var m = dt.getMonth()+1;
	var d = dt.getDate();
	return `${y}-${m}-${d}`
});

var vm=new Vue({
	el:"#app",
	data: {
		members: [{}],
		mine: '',
		goods:[{}],
		buydata:[{}],
		comment:[{}],
		accountC:[{}],
		bdata:[{}],
		backdata:[{}],
		odata:[{}],
		forsee:[{}]
	},
	methods: {

		lookone:function(){
			var t=this;
			axios.post('findone')
				.then(function (res) {
					t.mine=res.data;
				});
		},

        showgoods:function(){
            var t=this;
            axios.get('mygoods')
                .then(function (res) {
                    t.goods=res.data;
                });
        },

		showbuy:function(){
			var t=this;
			axios.get('orderbyshoper')
				.then(function (res) {
					t.buydata=res.data;
					for( var i = 0; i < t.buydata.length; i++ ){
						t.buydata[i].usedata = timestampToTime(t.buydata[i].usedata);
					}
				});
		},

		backg:function(){
			var t=this;
			var a=document.getElementById("gname").value;
			var b=document.getElementById("gsource").value;
			axios.get('addgoods',
				{params:{name:a,material:b}})
				.then(function(res){

				});
		},

		showcomment:function(){
			var t=this;
			axios.get('selectByshoper')
				.then(function (res) {
					t.comment=res.data;
					for( var i = 0; i < t.comment.length; i++ ){
						t.comment[i].usedata = timestampToTime(t.comment[i].usedata);
					}
				});
		},

		lookdata:function(){
			var t=this;
			axios.get('selectByshoper')
				.then(function (res) {
					t.bdata=res.data;
					for( var i = 0; i < t.bata.length; i++ ){
						t.bdata[i].usedata = timestampToTime(t.bdata[i].usedata);
					}
				});
		},

		seecomment:function(){
			var t=this;
			axios.get('customerComm')
				.then(function (res) {
					t.accountC=res.accountC;
					for( var i = 0; i < t.accountC.length; i++ ){
						t.accountC[i].usedata = timestampToTime(t.accountC[i].usedata);
					}
				});
		},

		dusedata:function(item){
			var t=this;
			axios.get('duserdata',
				{params:{coid:item.coid}})
				.then(function(res){
					t.accountC=res.data;
					for( var i = 0; i < t.accountC.length; i++ ){
						t.accountC[i].usedata = timestampToTime(t.accountC[i].usedata);
					}
				})
		},

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
	        }
	        

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

