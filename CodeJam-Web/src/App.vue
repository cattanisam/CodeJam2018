<template>
<div id="app">
<gmap-map 
    v-bind:center="center" 
    v-bind:zoom="7"
  style="height: 650px"
>
  </gmap-map>
</div>
</template>

<script>
export default {
  data() {
    return {
      center: { lat: 41.564, lng: -122.149 },
      mapTypeId: 'satellite'
      };
    }
  };

</script>

<style>

</style>
