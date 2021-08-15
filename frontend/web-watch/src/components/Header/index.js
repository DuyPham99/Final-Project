import './index.scss';
import logo from '../../assets/images/mac.png';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import SearchIcon from '@material-ui/icons/Search';
import { NavLink } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { Container } from '@material-ui/core';
import AccountCircleOutlinedIcon from '@material-ui/icons/AccountCircleOutlined';
function Header() {
    const style = {
        alignItems: 'center',
        color: 'white',
        fontSize: '26px',

    }
    const cart = useSelector(state => state.cart.cartItems);
    const login = useSelector(state => state.login);
    console.log(login.accessToken);
    return (
        <div className="header-nav">
            {/* <div className="header__account">
                <AccountCircleOutlinedIcon style={{ margin: '0 2px' }} />
                <NavLink to="/dangnhap"><span className="header__account-login">Đăng nhập</span></NavLink>
                <span style={{ margin: '0 4px', fontSize: '12px' }}>|</span>
                <NavLink to="/dangki"><span className="header__account-register">Đăng kí</span></NavLink>
            </div> */}
            <Container fixed>

                <div className="header-nav__nav">
                    <NavLink to='/' exact >
                        <div className="header-nav__logo">
                            {/* <img src="" alt='Logo'></img> */}
                            <p>
                                <span>M</span>
                                ac.vn
                            </p>
                        </div>
                    </NavLink>
                    <div className="header-nav__search">
                        <input className="header-nav__search-input" placeholder="Nhập từ khóa cần tìm"></input>
                        <button className="header-nav__search-button">
                            <SearchIcon style={{ color: 'white' }}></SearchIcon>
                        </button>
                    </div>
                    <div className="header-nav__links">
                        <ul className="header-nav__links-list">
                            <li className="header-nav__links-items">
                                <NavLink to='/' exact activeClassName="active"> Trang chủ</NavLink>
                            </li>
                            <li className="header-nav__links-items">
                                <NavLink to='/sanpham' activeClassName="active">Sản phẩm</NavLink>
                            </li>
                            <li className="header-nav__links-items">
                                <NavLink to='/tintuc'> Tin tức</NavLink>
                            </li>
                            <li className="header-nav__links-items">
                                <NavLink to='/lienhe'> Liên hệ</NavLink>
                            </li>
                        </ul>
                    </div>
                    <div className="header-nav__cart">
                        <NavLink to='/giohang'>
                            <ShoppingCartIcon style={style}></ShoppingCartIcon>
                            <span className="header-nav__cart-title">{cart.length}</span>
                        </NavLink>
                    </div>

                </div>
            </Container>
        </div>
    );
}
export default Header;