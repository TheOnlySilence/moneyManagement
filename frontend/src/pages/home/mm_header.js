import React, { Component } from 'react';
import './mm_header.css';

class Header extends Component {
  render() {
    return (
      <div className= "_head">
        <Header_logo/>
        <Header_menu/>
        <div className="_head_right">
          <Header_search/>
          <Header_info />
        </div>
      </div>
    );
  }
}

class Header_logo extends Component {
    render() {
      return (
        <div className= "_head_elements" id="head_logo">
          <a href="https://www.capitalone.com/?external_id=WWW_LP058_XXX_SEM-Brand_Google_ZZ_ZZ_T_Home_ZZ_e8f775ad-321f-4e2c-8877-ccc77536c2c6_25524&target_id=kwd-16416311&gclid=EAIaIQobChMIj8zmlsK04AIVFf_jBx0NYw6eEAAYASAAEgLsV_D_BwE"><img  src="https://chargeback.com/wp-content/uploads/capital-one-logo-300x104.png" alt="Capital one"></img></a>
        </div>
        
      );
    }
  }

  class Header_menu extends Component {
    render() {
      return (
        <ul className= "_head_elements" id="head_menu">
          <li><a href="#overview">Overview</a></li>
          <li><a href="#account_info">Account Information</a></li>
        </ul>
      );
    }
  }

  class Header_search extends Component{
      render() {
          return (
            <div className= "_head_elements" id="head_search">
                <input type="text" className="input" placeholder="Search..." />
                
                <div><a href="#search_request"><img src="https://nl.daysy.me/static/img/asset/icon.loupe.svg" alt="user_profile"></img></a></div>
          </div>
          );
      }
  }

  class Header_info extends Component {
    render() {
      return (
        <div className= "_head_elements" id="head_info">
        
          <img src="http://coolspotters.com/files/photos/90/steve-jobs-profile.png" alt="user_profile"></img>
        </div>
      );
    }
  }





export default Header;
