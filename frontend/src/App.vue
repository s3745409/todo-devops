<template>
  <section class="page-todo center">
    <div class="columns is-multiline">
      <div class="column is-12"><h2 class="title">Todo Application</h2></div>
      <div class="column is-8 is-offset-2">
        <div class="field has-addons">
          <div class="control is-flex-grow-1">
            <input
              class="input"
              type="text"
              placeholder="Create a task..."
              v-model="todo"
            />
          </div>
          <div class="control">
            <a class="button is-success" @click="addItem()">
              <i class="fas fa-plus"></i
            ></a>
          </div>
        </div>
      </div>
      <div class="column is-8 is-offset-2 todo-item-container">
        <div v-if="this.todoItems.items.length > 0">
          <TodoItem
            v-for="todo in this.todoItems.items"
            v-bind:key="todo.id"
            v-bind:todoItem="todo"
            v-on:removeFromList="removeTodoItem(todo.id)"
          />
        </div>
        <div v-else>"No items"</div>
      </div>
      <div class="column is-8 is-offset-2 todo-item-container">
        <i class="far fa-copyright"></i> danmeldominique
      </div>
    </div>
  </section>
</template>

<script>
import TodoItem from "@/components/TodoItem.vue";
import axios from "axios";
export default {
  name: "App",
  components: {
    TodoItem
  },
  data() {
    return {
      todo: "",
      todoItems: {
        items: [],
      },
    };
  },
  mounted() {
    this.getItems();
  },
  methods: {
    async getItems() {
      await axios
        .get("/api/todos")
        .then((res) => {
          this.todoItems.items = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async addItem() {
      await axios
        .post("/api/todos", {
          content: this.todo,
        })
        .then((res) => {
          console.log(res.data);
          this.getItems();
        })
        .catch((err) => {
          console.log(err);
        });
      this.todo = "";
    },
    async removeTodoItem(id) {
      await axios
        .delete("/api/todos/" + id)
        .then((res) => {
          console.log(res.data);
          this.getItems();
        })
        .catch((err) => {
          console.log(err);
          this.getItems();
        });
    },
  },
};
</script>

<style lang="scss">
@import "../node_modules/bulma";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.page-todo {
  height: 400px;
}
.center {
  margin: 0;
  position: absolute;
  top: 40%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
