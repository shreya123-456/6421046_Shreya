import React, { useState } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';

function App() {
  const [count, setCount] = useState(1);

  const increase = () => {
    setCount(count + 1);
    sayHello();
  };

  const decrease = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    alert('Hello! This is a static message.');
  };

  const sayWelcome = (msg) => {
    alert(msg);
  };

  const handleClick = () => {
    alert('I was clicked');
  };

  return (
    <div>
      <h1>{count}</h1>
      <button onClick={increase}>Increment</button>
      <button onClick={decrease}>Decrement</button>
      <button onClick={() => sayWelcome('Welcome')}>Say welcome</button>
      <button onClick={handleClick}>Click on me</button>
      <br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
