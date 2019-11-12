//组件--修改记录
var updatecustomer={
    template:'#updatecustomer',
        props:['parentupdate_customer'],
        methods:{
        update_customer:function(data){
            this.$emit('update',data);
            //this.$emit('load');
        }
    }

}

//组件--添加记录
var insertcustomer = {
    template:'#insertcustomer',
    props:[],
    data:function(){
        return{
            customer:{account:'',password:'',mobile:''}
        }

    },
    methods:{
        insert_customer:function(data){
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
            {path:'/insert',component:insertcustomer},
            {path:'/update',component:updatecustomer},
        ]
    }
);

//vue实例
var vm = new Vue({
    el:'#app',
    data:{
       customers:[],
        view:false,
        update_customer:{}
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
        gotoupdate:function (customer) {
            alert("click");
            this.update_customer = customer;
        },
        update:function(customer){
            var th =this;
            alert("go to update");
            console.log(customer);
            axios.post('/customer/update',customer).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to update customer");
                    this.$options.methods.loadCustomer(th);
                }
            }.bind(th));
        },
        insert:function(customer){
            var th =this
            alert("go to insert");
            console.log(customer);
            axios.post('/customer/insert',customer).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to insert customer");
                    this.$options.methods.loadCustomer(th);
                }
            }.bind(th));
        },
        deleteByCid:function (cid) {
            var th = this;
            alert("success to click");
            axios.get('/customer/delete',{params:{cid:cid}}).then(function(res){
                var result = res.data;
                console.log(result);
                if(result === 'success'){
                    alert("success to delete customer");
                    this.$options.methods.loadCustomer(th);
                }
            }.bind(th));
        },
        loadCustomer:function (th) {
            axios.get('/customer/selectAll',{params:{}}).then(function(result){
                th.customers = result.data;
                console.log(th.customers);
                console.log(th);

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
        updatecustomer: updatecustomer,
        insertcustomer: insertcustomer,
    },
    router:vmrouter,
    mounted:function(){
        var th = this;
        axios.get('/customer/selectAll',{params:{}}).then(function(result){
           th.customers = result.data;
           console.log(th.customers);
            th.view = "selectAll"

        });

    },


});
