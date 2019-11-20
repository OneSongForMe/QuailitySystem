
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
        goods:[{}]
    },

    created:function(){
        var t=this;
        axios.post('getgoods')
            .then(function (res) {
                t.goods=res.data;
            });
    }

});
