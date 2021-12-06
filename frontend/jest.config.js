module.exports = {
  reporters: [
    "default",
    "jest-junit"
  ],
  preset: '@vue/cli-plugin-unit-jest',
  transform: {
    '^.+\\.vue$': 'vue-jest'
  }
}
