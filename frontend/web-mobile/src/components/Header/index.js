import './index.scss';
import logo from '../../assets/images/logowatch.png';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import SearchIcon from '@material-ui/icons/Search';
import { NavLink } from 'react-router-dom';
import { useSelector } from 'react-redux';
function Header() {
    const style = {
        alignItems: 'center',
        color: 'white',
        fontSize: '30px',

    }
    const cart = useSelector(state => state.cart.cartItems);
    const login = useSelector(state => state.login);
    console.log(login.accessToken);
    return (
        <div className="header">
            <div className="header__nav">
                <NavLink to='/' exact >
                    <div className="header__logo">
                        <img src={logo} alt='Logo'></img>
                        <p>
                            <span>W</span>
                            atches
                        </p>
                    </div>
                </NavLink>
                <div className="header__search">
                    <input className="header__search-input" placeholder="Tìm kiếm..."></input>
                    <button className="header__search-button">
                        <SearchIcon style={{ color: 'black' }}></SearchIcon>
                    </button>
                </div>
                <div className="header__links">
                    <ul className="header__links-list">
                        <li className="header__links-items">
                            <NavLink to='/' exact activeClassName="active"> Trang chủ</NavLink>
                        </li>
                        <li className="header__links-items">
                            <NavLink to='/sanpham' activeClassName="active">Sản phẩm</NavLink>
                        </li>
                        <li className="header__links-items">
                            <NavLink to='/tintuc'> Tin tức</NavLink>
                        </li>
                        <li className="header__links-items">
                            <NavLink to='/lienhe'> Liên hệ</NavLink>
                        </li>
                    </ul>
                </div>

                <div className="header__login">
                    <NavLink to='/dangnhap' activeClassName="active">
                        <span className="header__login-title">Đăng nhập</span>
                    </NavLink>
                </div>
                <div className="header__cart">
                    <NavLink to='/giohang'>
                        <ShoppingCartIcon style={style}></ShoppingCartIcon>
                        <span>{cart.length}</span>
                    </NavLink>
                </div>

            </div>
        </div>
    );
}
export default Header;