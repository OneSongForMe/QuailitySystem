
var insertcomponent={
    template:'#insert',
    data:function () {
        return{
            comment:{pid:1,account:'zs',comment:'',picture:''}
        }
    },
    methods:{
        insert:function (comment) {
            this.$emit('insert',comment);
        }
    }
}

var updatecomponent={
    template:'#update',
    data:function () {
        return{
            comment:{}
        }
    },
    props:['parentcomment'],
    methods:{
        update:function(comment){
            this.$emit('update',comment);
        }
    }
}

var vmrouter = new VueRouter({

    routes:[
        {path:'/insert',component:insertcomponent},
        {path:'/update',component:updatecomponent},
    ]
});

var vm = new Vue({
   el:'#app',
   data:{
       comments:[],
       toupdate:{},
   } ,
    methods:{
       loadComment:function(th){
               axios.get('/comment/selectAll',{params:{}}).then(function(result){
                   th.comments = result.data;
                   console.log(th.comments);

               });
       },
        insert:function(comment){
           var th =this;
            axios.post('/comment/insert',comment).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to insert comment");
                    th.$options.methods.loadComment(th);
                }
            });
        },
        update:function(comment){
            var th =this;
            axios.post('/comment/update',comment).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to update comment");
                    th.$options.methods.loadComment(th);
                }
            });
        },
        deleteComment:function(coid){
           alert("go to delete comment");
           var  th =this;
            axios.get('/comment/delete',{params:{coid:coid}}).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to delete comment");
                    th.$options.methods.loadComment(th);
                }

            });
        },
        linkInsert:function(){
            this.$router.push({ path: 'insert' })
        },
        linkUpdate:function(comment){
            this.$router.push({ path: 'update' })
            this.toupdate=comment;
        },

    },
    router:vmrouter,
    components:{
        insertcomponent:insertcomponent,
        updatecomponent:updatecomponent,
    },
    mounted:function () {
        var th =this;
        this.$options.methods.loadComment(th);
    }
});