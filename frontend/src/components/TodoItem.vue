<template>
  <div class="field has-addons">
    <div class="control is-flex-grow-1">
      <input class="input" type="text" v-bind:value="item.content" disabled />
    </div>
    <div class="control">
      <a class="button is-danger" @click="removeFromList(item)"> <i class="far fa-trash-alt"></i> </a>
    </div>
  </div>
</template>
<script>
export default {
  name: 'TodoItem',
  props: {
    todoItem: Object,
  },
  data() {
    return {
      item: this.todoItem,
    };
  },
  methods: {
    removeFromList(item) {
      this.$emit("removeFromList", item);
    },
  },
};
</script>