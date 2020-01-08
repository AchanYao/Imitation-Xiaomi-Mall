<template>
  <div class="container">
    <b-carousel
      id="carousel-1"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        img-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6bd4174b8c5aad67a64864a5716ad152.jpg?thumb=1&w=1533&h=575&f=webp&q=90"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide
        img-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a4aa0cbfad7de34618c4bebdbdeee4e1.jpg?w=2452&h=920"
      ></b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        img-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a38b1d56409913d5dc869023ade36d94.jpg?thumb=1&w=1533&h=575&f=webp&q=90"
      ></b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide
        img-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e45bcdea59448cd82360662a331409fc.jpg?thumb=1&w=1533&h=575&f=webp&q=90"
      ></b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
      <b-carousel-slide
        img-src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/fc7c5cc595e12203796678eedd9c4250.jpg?thumb=1&w=1533&h=575&f=webp&q=90"
      ></b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
export default {
  name: "ItemCarousel"
};
</script>

<style>
</style>