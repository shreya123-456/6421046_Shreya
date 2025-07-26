import './App.css';

function App() {
  const heading = "Office Space";
  const image = <img src="/office.jpg" width="25%" height="25%" alt="Office Space" />;

  // Office space data
  const officeSpaces = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Regus", Rent: 65000, Address: "Bangalore" },
    { Name: "WeWork", Rent: 45000, Address: "Hyderabad" },
  ];

  return (
    <div className="App">
      <h1>{heading} , at Affordable Range</h1>
      {officeSpaces.map((item, index) => {
        const colors = [];
        if (item.Rent <= 60000) {
          colors.push('textRed');
        } else {
          colors.push('textGreen');
        }

        return (
          <div key={index}>
            {image}
            <h1><b>Name:</b> {item.Name}</h1>
            <h3 className={colors.join(' ')}><b>Rent:</b> Rs. {item.Rent}</h3>
            <h3><b>Address:</b> {item.Address}</h3>
            <br />
          </div>
        );
      })}
    </div>
  );
}

export default App;
