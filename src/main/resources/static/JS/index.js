var vm = new Vue({
    el:'#app',
    data:{
        account:'',
        keyword:'',
        productions:[],
        comments:[],
        isvisible:false,
        commentView:false,
        mycomment:''
    },
    methods:{
        select:function (keyword) {
            var th = this;
            axios.get('/production/selectByKeyword',{params:{keyword:keyword}}).then(function(res){
                var result = res.data;
                console.log(result);
                alert("success");
                if(result != null){
                    th.productions = result;
                    th.isvisible = true;
                }
               console.log(th.isvisible);
                console.log(th.productions);
            });
        },
        getComments:function (pid) {
            var th = this;
            axios.get('/comment/selectByProduction',{params:{pid:pid}}).then(function(res){
                var result = res.data;
                console.log(result);
                alert("got comments");
                if(result != null){
                    th.comments = result;
                    th.commentView = true;
                }
                console.log(th.comments);
            });
        },
        sendComment:function (pid) {
            var th = this;
            axios.get('/comment/insertComment',{params:{pid:pid,comment:th.mycomment}}).then(function(res){
                var result = res.data;
                console.log(result);
                alert("success to send comment");
            });
        }
    }
});
