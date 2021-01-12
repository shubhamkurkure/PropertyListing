import React from "react";
import {findGuestById, updateGuest} from "../services/guestService";
import {findHostById, updateHost} from "../services/hostService";
import HeadingGeneric from "../components/generics/HeadingGeneric.Component";
import {findAdminById, updateAdmin} from "../services/adminService";
import {Link} from "react-router-dom";

class ProfilePage extends React.Component {

    state = {
        firstname: "",
        lastname: "",
        username: "",
        updateMode: false
    }

    componentDidMount() {
        if (localStorage.getItem("userType") === "guest") {
            findGuestById(this.props.match.params.profileId)
                .then((response) => {
                    this.setState({
                                      firstname: response.firstName,
                                      lastname: response.lastName,
                                      username: response.login.userName,
                                  })
                })
        }

        if (localStorage.getItem("userType") === "host") {
            findHostById(this.props.match.params.profileId)
                .then((response) => {
                    this.setState({
                                      firstname: response.firstName,
                                      lastname: response.lastName,
                                      username: response.login.userName,
                                  })
                })

        }

        if (localStorage.getItem("userType") === "admin") {
            findAdminById(this.props.match.params.profileId)
                .then((response) => {
                    this.setState({
                                      firstname: response.firstName,
                                      lastname: response.lastName,
                                      username: response.login.userName,
                                  })
                })

        }
    }

    usernameChangeHandler = (event) => {
        this.setState({
                          username: event.target.value
                      })
    }

    lastnameChangeHandler = (event) => {
        this.setState({
                          lastname: event.target.value
                      })
    }

    firstnameChangeHandler = (event) => {
        this.setState({
                          firstname: event.target.value
                      })
    }

    toggleUpdate = () => {
        this.setState((prevState) => ({
            updateMode: !prevState.updateMode
        }))
    }

    render() {
        return (
            <div className={"container"}>
                <HeadingGeneric text={"Profile details"}/>
                {
                    !this.state.updateMode &&
                    <div>
                        <h4>Firstname : {this.state.firstname}</h4>
                        <h4>Lastname : {this.state.lastname}</h4>
                        <h4>Username : {this.state.username}</h4>
                    </div>
                }

                {
                    this.state.updateMode &&
                    <div>
                        <input className={"form-control"} onChange={this.firstnameChangeHandler}
                               value={this.state.firstname}/>
                        <input className={"form-control"} onChange={this.lastnameChangeHandler}
                               value={this.state.lastname}/>
                        <input className={"form-control"} onChange={this.usernameChangeHandler}
                               value={this.state.username}/>
                    </div>
                }


                {
                    !this.state.updateMode &&
                    <button className={"btn btn-primary"} onClick={() => {
                        this.toggleUpdate();
                    }}>Update profile
                    </button>
                }

                {
                    this.state.updateMode &&
                    <button className={"btn btn-success"} onClick={()=>{
                        if(localStorage.getItem("userType") === "guest") {
                            updateGuest({
                                firstName:  this.state.firstname,
                                lastName:  this.state.lastname,
                                userName:  this.state.username
                                        }, localStorage.getItem("uid") )
                                .then((response) =>{
                                    console.log(response);
                                    alert("Profile updated successfully")
                                    this.toggleUpdate();
                                })
                        }

                        if(localStorage.getItem("userType") === "host") {
                            updateHost({
                                            firstName:  this.state.firstname,
                                            lastName:  this.state.lastname,
                                            userName:  this.state.username
                                        },localStorage.getItem("uid"))
                                .then((response) =>{
                                    console.log(response);
                                    alert("Profile updated successfully")
                                    this.toggleUpdate();
                                })
                        }

                        if(localStorage.getItem("userType") === "guest") {
                            updateAdmin({
                                            firstName:  this.state.firstname,
                                            lastName:  this.state.lastname,
                                            userName:  this.state.username
                                        },localStorage.getItem("uid"))
                                .then((response) =>{
                                    console.log(response);
                                    alert("Profile updated successfully")
                                    this.toggleUpdate();
                                })
                        }
                    }
                    }>Done</button>
                }

                <br/>
                {
                    localStorage.getItem("userType") === "host" &&
                    <Link to={"/properties"}>Properties</Link>
                }

                <br/>
                <Link to={"/trips"}>Trips</Link>
            </div>
        );
    }

}

export default ProfilePage;
