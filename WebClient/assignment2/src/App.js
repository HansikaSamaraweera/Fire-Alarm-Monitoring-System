import React, {Component} from 'react';
import './App.css';
import axios from "axios";
import Table from 'react-bootstrap/Table';


class App extends Component {

    

  constructor(props) {
    super(props);
    this.state = {
      values: [],
      isLoaded: false
    }
  }
    interval = null;

    componentDidMount() {
        this.interval = setInterval(this.getData, 40000);
        this.getData();
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }

    getData = () => {
    axios.get('http://localhost:8080/sensor/getsensor').then((response) => {
      this.setState({
        values: response.data,
      })
    });
  }

  render() {

    let values = this.state.values.map((x) => {

      if(x.coLevel>5 || x.smokeLevel>6){
          return (

              <tr bgcolor={"#c70404"} key={x.sensorId} style={{ color: 'white' }}>

                <td>{x.sensorId}</td>
                <td>{x.roomNo}</td>
                <td>{x.floorNo}</td>
                <td>{x.coLevel}</td>
                <td>{x.smokeLevel}</td>
                <th>Active</th>


              </tr>
          );
          }
        else
          return(
            <tr key={x.sensorId}>

                <td>{x.sensorId}</td>
                <td>{x.roomNo}</td>
                <td>{x.floorNo}</td>
                <td>{x.coLevel}</td>
                <td>{x.smokeLevel}</td>
                <th>Active</th>

            </tr>
          )
        });
    return (
        <div className="App container">
            <div className='mt-5'>
                <div className='mb-5'>
                    <h2 >Fire Alarm Table</h2></div>
          <Table striped bordered >
            <thead>
            <tr bgcolor={"#373a3d"} style={{ color: 'white' }}>
              <th>Sensor Id</th>
              <th>Room No</th>
              <th>Floor No</th>
              <th>CO2 Level</th>
              <th>Smoke Level</th>
              <th>State</th>
            </tr>
            </thead>

            <tbody>
              {values}
            </tbody>

          </Table>
        </div>
        </div>
    );
  }
}

export default App;
