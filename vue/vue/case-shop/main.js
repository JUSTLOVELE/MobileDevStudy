const app = new Vue({
    el: '#app',
    data: {
        books: [{
            id:1,
            name: '算法导论1',
            date: '2006-09',
            price: 86.03,
            count: 1
        },{
            id:1,
            name: '算法导论2',
            date: '2006-09',
            price: 84.09,
            count: 1
        },{
            id:1,
            name: '算法导论3',
            date: '2006-09',
            price: 86.01,
            count: 1
        },{
            id:1,
            name: '算法导论4',
            date: '2006-09',
            price: 86.02,
            count: 1
        },]
    },
    filters: {
        showPrice(price) {
            return '￥' + price.toFixed(2)
        }
    },
    methods: {
        increment(index) {
            this.books[index].count++
        },
        decrement(index) {

            if(this.books[index].count > 0) {
                this.books[index].count--
            }else{
                alert("库存不能小于0")
            }
           
        }
    }
})