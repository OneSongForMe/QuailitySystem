//组件--修改记录
var updateproduction={
    template:'#updateproduction',
        props:['parentupdate_production'],
        methods:{
        update_production:function(data){
            this.$emit('update',data);
            //this.$emit('load');
        }
    }

}

//组件--添加记录
var insertproduction = {
    template:'#insertproduction',
    props:['parentinsert_production'],
    data:function(){
        return{
            production:{}
        }

    },
    methods:{
        insert_production:function(data){
            this.$emit('insert',data);
            // this.$emit('load');
        }
    }

}

//路由
var vmrouter = new VueRouter(
    {
        routes:[
            //{path:'/',redirect:'/c'},
            {path:'/insert',component:insertproduction},
            {path:'/update',component:updateproduction},
        ]
    }
);

//vue实例
var vm = new Vue({
    el:'#app',
    data:{
       productions:[],
        update_production:{}
    },
    methods:{
        select:function () {
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
        gotoupdate:function (production) {
            alert("click");
            this.update_production = production;
        },
        update:function(production){
            var th = this;
            alert("go to update");
            console.log(production);
            axios.post('/production/update',production).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to update production");
                    this.$options.methods.loadProduction(th);
                }
            }.bind(this));
        },
        insert:function(production){
            var th = this;
            alert("go to insert");
            console.log(production);
            axios.post('/production/insert',production).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to insert production");
                    this.$options.methods.loadProduction(th);
                }
            }.bind(this));
        },
        deleteByPid:function (pid) {
            var th = this;
            alert("success to click");
            axios.get('/production/delete',{params:{pid:pid}}).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to delete production");
                    this.$options.methods.loadProduction(th);
                }
            }.bind(this));
        },
        loadProduction:function (th) {
            axios.get('/production/loadProduction',{params:{}}).then(function(result){
                th.productions = result.data;
                console.log(th.productions);
            });
        },
        linkInsert:function(){
            this.$router.push({ path: 'insert' })
        },
        linkUpdate:function(){
            this.$router.push({ path: 'update' })
        },
    },
    components: {
        //挂载组件实例
        updateproduction: updateproduction,
        insertproduction: insertproduction,
    },
    router:vmrouter,
    mounted:function(){
        var th = this;
        axios.get('/production/loadProduction',{params:{}}).then(function(result){
           th.productions = result.data;
           console.log(th.productions);
        });

    },


});
