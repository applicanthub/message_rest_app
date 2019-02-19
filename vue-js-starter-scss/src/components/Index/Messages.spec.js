import { shallow } from '@vue/test-utils';
import Messages from './Messages.vue';

describe('Messages.vue', () => {
  const messages = [
    {
      title: 'test1',
      body: 'test content',
    },
    {
      title: 'test2',
      body: 'test content',
    },
  ];
  it('Displays all messages', () => {
    const wrapper = shallow(Messages, {
      propsData: { messages },
    });
    expect(wrapper.findAll('li')).toHaveLength(messages.length);
  });
});
