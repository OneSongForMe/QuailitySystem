var vm = new Vue({
    el:'#app',
    data:{
        account:'',
        member:{uesrname:'zs',password:123}
    },
    methods:{
        tt:function(){
            this.member.uesrname = '2333';
            console.log("ok");
        },
        isExist:function(account){
            axios.get('/login/isExist',{params:{account:account}}).then(function(datas){
                myjson = datas.data;
                console.log(myjson);
                if(myjson === 'isExist'){
                    alert("isExist");
                }else{
                    alert("is not isExist");
                }
                });
            }
        }
});
