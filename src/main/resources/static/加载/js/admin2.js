
function zhankai1(){
	var a=document.getElementById("users1");
	var b=document.getElementById("users2");
	var c=document.getElementById("eq1");
	var d=document.getElementById("eq2");
	var e=document.getElementById("eq3");
	var f=document.getElementById("item1");
	var h=document.getElementById("data1");
	var i=document.getElementById("data2");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
	b.style.display="block";
	c.style.display="none";
	d.style.display="none";
	e.style.display="none";
	f.style.display="none";
	h.style.display="none";
	i.style.display="none";
	a.style.display="none";
}
function zhankai2(){
	var b=document.getElementById("equp");
	if(b.style.display=="block"){
		b.style.display="none";
	}else{
	b.style.display="block";
			}
}
function zhankai3(){
	var b=document.getElementById("item");
	if(b.style.display=="block"){
		b.style.display="none";
	}else{
	b.style.display="block";
			}
}
function zhankai4(){
	var a=document.getElementById("users1");
	var b=document.getElementById("users2");
	var c=document.getElementById("eq1");
	var d=document.getElementById("eq2");
	var e=document.getElementById("eq3");
	var f=document.getElementById("item1");
	var h=document.getElementById("data1");
	var i=document.getElementById("data2");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="block";
	g.style.display="none";
	b.style.display="none";
	c.style.display="none";
	d.style.display="none";
	e.style.display="none";
	f.style.display="none";
	h.style.display="none";
	i.style.display="none";
	a.style.display="none";
}
function zhankai5(){
	
	var bb=document.getElementById("anydata");
	var cc=document.getElementById("analys");
	cc.style.display="block";
	if(bb.style.display=="block"){
		bb.style.display="none";
	}else{
		bb.style.display="block";
	}
	var a=document.getElementById("users1");
	var b=document.getElementById("users2");
	var c=document.getElementById("eq1");
	var d=document.getElementById("eq2");
	var e=document.getElementById("eq3");
	var f=document.getElementById("item1");
	var h=document.getElementById("data1");
	var i=document.getElementById("data2");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="block";
	b.style.display="none";
	c.style.display="none";
	d.style.display="none";
	e.style.display="none";
	f.style.display="none";
	h.style.display="none";
	i.style.display="none";
	a.style.display="none";
}

function show5(){
	var a=document.getElementById("leftbtn5");

	a.style.color="red";

}

function hide5(){
	var a=document.getElementById("leftbtn5");
	a.style.color="white";
}

function show1(){
	var a=document.getElementById("leftbtn1");
	
	a.style.color="red";

}

function hide1(){
	var a=document.getElementById("leftbtn1");
	a.style.color="white";
}


function show2(){
	var a=document.getElementById("leftbtn2");
	a.style.color="red";
}
function hide2(){
	var a=document.getElementById("leftbtn2");
	a.style.color="white";
}


function show3(){
	var a=document.getElementById("leftbtn3");
	a.style.color="red";
}
function hide3(){
	var a=document.getElementById("leftbtn3");
	a.style.color="white";
}


function show4(){
	
	var aa=document.getElementById("leftbtn4");
	aa.style.color="red";
	}
function hide4(){
	var a=document.getElementById("leftbtn4");
	a.style.color="white";
}
function showt(){
	
}


//时钟
var clock = new Vue({
    el: '#clock',
    data: {
        time: '',
        date: ''
    }
});

var week = ['星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
var timerID = setInterval(updateTime, 1000);
updateTime();
function updateTime() {
    var cd = new Date();
    clock.time = zeroPadding(cd.getHours(), 2) + ':' + zeroPadding(cd.getMinutes(), 2) + ':' + zeroPadding(cd.getSeconds(), 2);
    clock.date = zeroPadding(cd.getFullYear(), 4) + '-' + zeroPadding(cd.getMonth()+1, 2) + '-' + zeroPadding(cd.getDate(), 2) + ' ' + week[cd.getDay()];
};

function zeroPadding(num, digit) {
    var zero = '';
    for(var i = 0; i < digit; i++) {
        zero += '0';
    }
    return (zero + num).slice(-digit);
}
function user1(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
var g=document.getElementById("analys");
var s=document.getElementById("memberusedata");
s.style.display="none";
g.style.display="none";
a.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function user2(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
b.style.display="block";
a.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function eq1(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
var g=document.getElementById("analys");
var s=document.getElementById("memberusedata");
s.style.display="none";
g.style.display="none";
c.style.display="block";
b.style.display="none";
a.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function eq2(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
var g=document.getElementById("analys");
var s=document.getElementById("memberusedata");
s.style.display="none";
g.style.display="none";
d.style.display="block";
b.style.display="none";
c.style.display="none";
a.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function eq3(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
var g=document.getElementById("analys");
var s=document.getElementById("memberusedata");
s.style.display="none";
g.style.display="none";
e.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
a.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function item1(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
f.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
a.style.display="none";
h.style.display="none";
i.style.display="none";
j.style.display="none";
}
function data1(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
h.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
a.style.display="none";
i.style.display="none";
j.style.display="none";
}
function data2(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
i.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
a.style.display="none";
j.style.display="none";
}
function data3(){
var a=document.getElementById("users1");
var b=document.getElementById("users2");
var c=document.getElementById("eq1");
var d=document.getElementById("eq2");
var e=document.getElementById("eq3");
var f=document.getElementById("item1");
var h=document.getElementById("data1");
var i=document.getElementById("data2");
var j=document.getElementById("data3");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="none";
j.style.display="block";
b.style.display="none";
c.style.display="none";
d.style.display="none";
e.style.display="none";
f.style.display="none";
h.style.display="none";
i.style.display="none";
a.style.display="none";
}
function useanalys1() {
	var a=document.getElementById("users1");
	var b=document.getElementById("users2");
	var c=document.getElementById("eq1");
	var d=document.getElementById("eq2");
	var e=document.getElementById("eq3");
	var f=document.getElementById("item1");
	var h=document.getElementById("data1");
	var i=document.getElementById("data2");
	var j=document.getElementById("data3");
	var g=document.getElementById("analys");
	var s=document.getElementById("memberusedata");
	s.style.display="none";
	g.style.display="block";
	j.style.display="none";
	b.style.display="none";
	c.style.display="none";
	d.style.display="none";
	e.style.display="none";
	f.style.display="none";
	h.style.display="none";
	i.style.display="none";
	a.style.display="none";


}

function showt2(){
	document.getElementById("t2");
	t2.style.display="block";
}



function useanalys1() {
	var b=document.getElementById("ana");
	b.style.display="block";
	var myChart = echarts.init(document.getElementById("ana"));
	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '物料使用情况'
		},
		tooltip: {},
		legend: {},
		toolbox: {},
		xAxis: [{
			name:'物料名称',
			data: []
		}],
		yAxis: { },
		series: [{
			name: '使用数量',
			type: 'bar',
			data: []
		},
			// {
			//     name: '最低气温',
			//     type: 'bar',
			//     data: [1, -2, 2, 5, 3, 2, 0]
			// }
		]
	};
	function loadDATA(option){
		var a=document.getElementById("key").value;
		$.ajax({
			type : "get",
			async : false, //同步执行
			url: encodeURI("echart1?type="+a),
			data:{},
			dataType : "json", //返回数据形式为json
			success : function(result) {
				if (result) {
					//初始化option.xAxis[0]中的data
					option.xAxis[0].data=[];
					for(var i=0;i<result.length;i++){
						option.xAxis[0].data.push(result[i].goodsname);
					}
					//初始化option.series[0]中的data
					option.series[0].data=[];
					for(var i=0;i<result.length;i++){
						option.series[0].data.push(parseFloat(result[i].usernumber));
					}
				}
			}
		});
	}

	// 使用刚指定的配置项和数据显示图表。
	loadDATA(option);
	myChart.setOption(option);

}
function useanalys2() {
	var b=document.getElementById("ana");
	b.style.display="block";
	var myChart = echarts.init(document.getElementById("ana"));
	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '物料使用情况'
		},
		tooltip: {},
		legend: {},
		toolbox: {},
		xAxis: [{
			name:'物料名称',
			data: []
		}],
		yAxis: { },
		series: [{
			name: '使用物料数量',
			type: 'bar',
			data: []
		},
			// {
			//     name: '最低气温',
			//     type: 'bar',
			//     data: [1, -2, 2, 5, 3, 2, 0]
			// }
		]
	};
	function loadDATA(option){
		var a=document.getElementById("key").value;
		$.ajax({
			type : "get",
			async : false, //同步执行
			url : encodeURI("echart2?username="+a),
			data : {},
			dataType : "json", //返回数据形式为json
			success : function(result) {
				if (result) {
					//初始化option.xAxis[0]中的data
					option.xAxis[0].data=[];
					for(var i=0;i<result.length;i++){
						option.xAxis[0].data.push(result[i].goodsname);
					}
					//初始化option.series[0]中的data
					option.series[0].data=[];
					for(var i=0;i<result.length;i++){
						option.series[0].data.push(parseFloat(result[i].usernumber));
					}
				}
			}
		});
	}

	// 使用刚指定的配置项和数据显示图表。
	loadDATA(option);
	myChart.setOption(option);

}
function useanalys3() {
	var b=document.getElementById("ana");
	b.style.display="block";
	var myChart = echarts.init(document.getElementById("ana"));
	// 指定图表的配置项和数据
	var option = {
		title: {
			text: '物料使用情况'
		},
		tooltip: {},
		legend: {},
		toolbox: {},
		xAxis: [{
			name:'物料名称',
			data: []
		}],
		yAxis: { },
		series: [{
			name: '使用数量',
			type: 'bar',
			data: []
		},
			// {
			//     name: '最低气温',
			//     type: 'bar',
			//     data: [1, -2, 2, 5, 3, 2, 0]
			// }
		]
	};
	function loadDATA(option){
		var a=document.getElementById("key").value;
		$.ajax({
			type : "get",
			async : false, //同步执行
			url : encodeURI("echart3?usedata="+a),
			data : {},
			dataType : "json", //返回数据形式为json
			success : function(result) {
				if (result) {
					//初始化option.xAxis[0]中的data
					option.xAxis[0].data=[];
					for(var i=0;i<result.length;i++){
						option.xAxis[0].data.push(result[i].goodsname);
					}
					//初始化option.series[0]中的data
					option.series[0].data=[];
					for(var i=0;i<result.length;i++){
						option.series[0].data.push(parseFloat(result[i].usernumber));
					}
				}
			}
		});
	}

	// 使用刚指定的配置项和数据显示图表。
	loadDATA(option);
	myChart.setOption(option);

}
