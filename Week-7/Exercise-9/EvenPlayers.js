import React from 'react';

const EvenPlayers = ({ team }) => {
  const [, second, , fourth, , sixth] = team;
  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
};

export default EvenPlayers;
