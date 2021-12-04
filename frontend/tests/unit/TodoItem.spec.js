import { mount } from '@vue/test-utils'
import TodoItem from '@/components/TodoItem.vue'

describe('TodoItems render correctly', () => {
  it('TodoItem uses prop in render', () => {
    const item = {
      "createdOn": "2021-12-03T05:14:37.169+00:00",
      "content": "sadasdsad",
      "id": 5
  }
    const wrapper = mount(TodoItem, {
      props: { todoItem: item }
    })
    expect(wrapper.find('input').element.value).toMatch(item.content)
  })
})
