<template>
  <div class="main-content">
    <div>
      <el-carousel height="450px">
        <el-carousel-item v-for="item in carouselData" :key="item">
          <img :src="item" alt="" style="height: 450px; width: 100%">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div style="width: 70%; margin: 40px auto; font-size: 22px; color: #666666">专业平台，放心预订</div>
    <div style="width: 50%; margin: 20px auto; display: flex">
      <div style="flex: 1; text-align: center">
        <img src="@/assets/imgs/飞机票.png" alt="" style="height: 100px; width: 100px; cursor: pointer">
        <div style="margin-top: 10px; font-size: 16px; color: #404144">飞机票预订</div>
      </div>
      <div style="flex: 1; text-align: center">
        <img src="@/assets/imgs/火车票.png" alt="" style="height: 100px; width: 100px; cursor: pointer">
        <div style="margin-top: 10px; font-size: 16px; color: #404144">火车票预订</div>
      </div>
      <div style="flex: 1; text-align: center">
        <img src="@/assets/imgs/汽车票.png" alt="" style="height: 100px; width: 100px; cursor: pointer">
        <div style="margin-top: 10px; font-size: 16px; color: #404144">汽车票预订</div>
      </div>
    </div>
    <div style="width: 70%; margin: 40px auto; font-size: 22px; color: #666666">旅游攻略，省时省心
      <span style="margin-left: 20px; font-size: 14px; color: #bbbbbb; cursor: pointer">查看更多</span>
    </div>
    <div style="width: 70%; margin: 20px auto; min-height: 300px">
      <el-row :gutter="20">
        <el-col :span="6">
          <img src="@/assets/imgs/lun-1.jpg" alt="" style="height: 160px; width: 100%; cursor: pointer; border-radius: 5px">
          <div style="margin-top: 10px; font-size: 15px; color: #666666" class="overflowShow">
            浙江省杭州市西湖区【西山人家】浙江省杭州市西湖区【西山人家】浙江省杭州市西湖区【西山人家】
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>

export default {

  data() {
    return {
      carouselData: [
        require('@/assets/imgs/lun-1.jpg'),
        require('@/assets/imgs/lun-2.jpg'),
      ]
    }
  },
  mounted() {

  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {

  }
}
</script>
<style>
.overflowShow {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis
}
</style>