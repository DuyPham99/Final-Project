import '../Banner/index.scss';
import React from 'react';
import banner from '../../assets/images/banner.jpg';
function Banner() {
    return (
        <React.Fragment>
            <div className="banner" style={{ backgroundImage: `url(${banner})` }}>
                <div className="banner__title">
                    <h1>Welcome to our Shop</h1> 
                </div>
            </div>

        </React.Fragment>

    );
}
export default Banner;