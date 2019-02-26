import React, {Component} from 'react';
import './App.css';
import { BrowserRouter, Route } from 'react-router-dom'
import Header from "./pages/home/mm_header"
import Content from "./pages/home/mm_content"
import Login from "./pages/login"

const user_profile = [
    "Geesun Jang"
];

class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <div className="App">
                    <Header/>
                    <Route path='/' exact component={Login}></Route>
                    <Route path='/detail/:id' exact component={Content}></Route>
                </div>
            </BrowserRouter>
        );
    }
}

export default App;
