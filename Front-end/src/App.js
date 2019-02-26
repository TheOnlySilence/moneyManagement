import React, { Component } from 'react';
import './App.css';
import Header from "./components/mm_header"
import Overview from "./components/OVERVIEW"
import Table_sample from "./components/tr_table"
import {BrowserRouter, Route, Switch } from "react-router-dom";
import Acc_info from "./components/ACC_INFO"
const user_profile = [
  "Geesun Jang"
];




class App extends Component {
  render() {
    return (
      <div className="App">
    <BrowserRouter>
        <div>
        <Header/>
        <Switch>
            <Route path="/" component={Overview} exact/>
            <Route path="/OVERVIEW" component={Overview}/>
            <Route path="/ACC_INFO" component={Acc_info}/>
        </Switch>
        </div>
      </BrowserRouter>
     
      </div>
    );
  }
}

export default App;
