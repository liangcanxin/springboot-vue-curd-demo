var app = new Vue({
  el: '#app',
  data: {
    searchItems: {
      name: '姓名',
      phone: '联系方式',
      address: '联系地址',
      email: '邮箱'
    },
    searchConditionKey: '',
    searchConditionValue: '关键词',
    searchKeyword: '',

    curdType: '',
    curdTitleItems: [
      '新增信息',
      '查看详情',
      '更新信息',
      '删除信息'
    ],
    curdTitle: '',
    detailItems: {
      name: '姓名',
      sex: '性别',
      marry: '婚姻情况',
      phone: '联系方式',
      address: '联系地址',
      email: '邮箱',
      createTime: '创建时间',
      updateTime: '更新时间'
    },
    itemsData: [],
    detailItemsData: {},
    tipsInfo: '',

    page: 1,
    lastPage: '',
    chooseItemId: ''
  },
  created() {
    // 初始化列表
    this.getInfos('', '', 1)
  },
  methods: {
    // 设置筛选项
    setSearchCondition(key, value) {
      this.searchConditionKey = key
      this.searchConditionValue = value
    },
    // 筛选搜索
    search() {
      if (this.searchKeyword && !this.searchConditionKey) {
        this.showTipsInfo("请选择筛选项!")
        return
      }
      this.getInfos(this.searchConditionKey, this.searchKeyword, this.page)
    },
    // 设置增删查改弹窗内容
    toCurdData(curdType, itemId) {
      this.detailItemsData = {}
      this.curdTitle = this.curdTitleItems[curdType]
      this.curdType = curdType
      this.chooseItemId = itemId
      // 此时, curdType为1或2, 表示查看详情或更新数据, 需渲染原数据
      if (curdType == 1 || curdType == 2) {
        this.getInfoById(itemId)
      }
    },
    // 提交数据
    handleCurdData(detailItemsData) {
      // 如果当前为删除操作
      if (this.curdType == 3) {
        this.deleteInfo(this.chooseItemId)
        return
      }
      // 如果当前为新增操作
      if (this.curdType == 0) {
        this.saveInfo(detailItemsData)
        return
      }
      // 如果当前为更新操作
      if (this.curdType == 2) {
        this.updateInfo(detailItemsData)
        return
      }
    },
    // 提示框(封装)
    showTipsInfo(tips) {
      this.tipsInfo = tips
      $('#handleCurdToast').toast('show')
      // 刷新列表
      this.search()
    },
    // 前一页
    previousPage() {
      if (this.page == 1) {
        this.showTipsInfo("当前为搜索数据的第一页数据!")
        return
      }
      this.page = Number(this.page) - 1
      this.search()
    },
    // 监听页码变化
    changePageInput() {
      if (this.page < 1 || this.page > this.lastPage) {
        this.showTipsInfo('当前输入页码无效!')
        return
      }
      this.search()
    },
    // 后一页
    nextPage() {
      if (this.page == this.lastPage) {
        this.showTipsInfo("当前为搜索数据的最后一页数据!")
        return
      }
      this.page = Number(this.page) + 1
      this.search()
    },
    // 响应体(校验封装)
    responseCheck (respData) {
      if (respData.data.code != 1) {
        this.showTipsInfo(respData.data.message)
        return false
      }
      return true
    },
    // 响应体(封装, 仅适用于curd)
    responseCheckForCurd (respData, handleType) {
      $('#curdModal').modal('hide')
      console.log(respData, '响应信息')
      // 如果操作成功
      if (respData.data.code == 1) {
        this.showTipsInfo(handleType + '操作成功!')
        return
      }
      this.showTipsInfo(handleType + '操作失败! 原因: ' + resp.data.message)
    },
    // 获取筛选的所有信息
    getInfos(searchConditionKey, searchKeyword, pageNum) {
      var that = this
      axios.get("http://localhost:8080/info/", {
        params: {
          pageNum: pageNum,
          key: searchConditionKey,
          value: searchKeyword
        }
      }).then(
        function (resp) {
          console.log(resp)
          that.itemsData = resp.data.data.records
          that.page = resp.data.data.current
          that.lastPage = resp.data.data.pages
        },
        function (err) {
          console.log(err)
          that.showTipsInfo('请求后台数据出错!')
        }
      )
    },
    // 通过id查询指定信息
    getInfoById(id) {
      var that = this
      axios.get("http://localhost:8080/info/" + id).then(
        function (resp) {
          that.detailItemsData = resp.data.data
        },
        function (err) {
          console.log(err)
          that.showTipsInfo('请求后台数据出错!')
        }
      )
    },
    // 保存信息
    saveInfo(detailItemsData) {
      var that = this
      axios.post("http://localhost:8080/info/", detailItemsData).then(
        function (resp) {
          that.responseCheckForCurd(resp, '新增信息')
        },
        function (err) {
          console.log(err)
          that.showTipsInfo('请求后台数据出错!')
        }
      )
    },
    // 更新信息
    updateInfo(detailItemsData) {
      var that = this
      axios.put("http://localhost:8080/info/", detailItemsData).then(
        function (resp) {
          that.responseCheckForCurd(resp, '更新信息')
        },
        function (err) {
          console.log(err)
          that.showTipsInfo('请求后台数据出错!')
        }
      )
    },
    // 删除信息
    deleteInfo(id) {
      var that = this
      console.log(id)
      axios.delete("http://localhost:8080/info/" + id).then(
        function (resp) {
          that.responseCheckForCurd(resp, '删除信息')
        },
        function (err) {
          console.log(err)
          $('#curdModal').modal('hide')
          that.showTipsInfo('请求后台数据出错!')
        }
      )
    }
  }
})