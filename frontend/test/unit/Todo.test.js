import {mount} from '@vue/test-utils'
import TodoItem from '../../src/components/TodoItem.vue'

test('renders todo item', () => {
    let todoItem = {
        "createdOn": "2021-12-03T05:14:37.169+00:00",
        "content": "sadasdsad",
        "id": 5
    }

    const wrapper = mount(TodoItem, {
        props: {todoItem}
    })
    const todo = wrapper.get("input[class='login']")
    expect(todo.text()).toBe('sadasdsad')
})