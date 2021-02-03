import React, {Component} from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link, withRouter} from 'react-router-dom';
import Routes from "./routing/Routes";
import {Collapse, Navbar, NavLink, NavItem, Nav} from 'reactstrap';
import NavbarToggle from "react-bootstrap/NavbarToggle";

class App extends Component {
    constructor(props) {
        super(props);

      this.state = {
          isOpen: false
      } ;
    }

    toggle = () => {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return (
            <div className="App container">
                <Navbar className="navbar-dark bg-dark fixed-top" expand="md">
                    <NavLink tag={Link} to="/" className="navbar-brand">
                        CAMRES
                    </NavLink>

                    <NavbarToggle onClick={this.toggle}/>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="navbar-nav me-auto mb-2 mb-md-0" navbar>
                            <NavItem>
                                <NavLink tag={Link} to="/proveedores">Proveedores</NavLink>
                            </NavItem>

                            <NavItem>
                                <NavLink tag={Link} to={"/facturas"}>Facturas</NavLink>
                            </NavItem>

                            <NavItem>
                                <NavLink tag={Link} to={"/balance"}>Balance</NavLink>
                            </NavItem>
                        </Nav>
                    </Collapse>
                </Navbar>
                <Routes/>
            </div>
        );
    }

}

export default withRouter(App);


/*
 <div className="App container">
               <Navbar color="ligth" ligth expand="md">
                   <NavLink tag={Link} to="/" className="navbar-item">
                       CAMRES
                   </NavLink>

                   &nbsp;
                   &nbsp;

                   <NavbarToggle onClick={this.toggle}/>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                            <NavItem>
                                <NavLink tag={Link} to="/proveedores">Proveedores</NavLink>
                            </NavItem>
                        </Nav>
                    </Collapse>
               </Navbar>
               <Routes/>
           </div>



*
*  <div className="App container">
                <nav className="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
                    <div className="container-fluid">
                        <a className="nav-link" to={"/"}>CAMRES</a>

                        <div className="collapse navbar-collapse" id="navbarsExampleDefault">
                            <ul className="navbar-nav me-auto mb-2 mb-md-0">
                                <NavItem>
                                    <NavLink tag={Link} exact to={"/proveedores"} onClick={console.log("HACE CLIC")}>Proveedores</NavLink>
                                </NavItem>

                                <NavItem>
                                    <NavLink tag={Link} to={"/facturas"}>Facturas</NavLink>
                                </NavItem>

                                <NavItem>
                                    <NavLink tag={Link} to={"/balance"}>Balance</NavLink>
                                </NavItem>
                            </ul>
                        </div>
                    </div>
                </nav>
                <Routes/>

            </div>
* */
