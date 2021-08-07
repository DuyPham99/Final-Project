import '../News/index.scss';
import { Grid } from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';
import tintuc1 from '../../assets/images/tintuc1.jpg';
import tintuc2 from '../../assets/images/tintuc2.jpg';
import tintuc3 from '../../assets/images/tintuc3.jpg';
import tintuc4 from '../../assets/images/tintuc4.jpg';
import tintuc5 from '../../assets/images/tintuc5.jpg';
function News() {
    return (
        <div className="news">
            <div className="news__search">
                <input className="news__search-input" type="text" placeholder="Tìm kiếm"></input>
                <button className="news__search-btn">
                    <SearchIcon style={{ color: "black" }}></SearchIcon>
                </button>
            </div>
            <h3 className="news__title">Bài viết mới</h3>
            <Grid container spacing={1}>
                <Grid item xs={4} className="news__list">
                    <img className="news__list-img" alt="tin tức 1" src={tintuc1}></img>
                    <div className="news__list-info">
                        <p className="news__list-title">Chiếc đồng hồ của những CEO quyền lực nhất thế giới</p>
                        <span className="news__list-des"> Đối với một số doanh nhân, một chiếc đồng hồ đeo tay không chỉ là thiết bị xem giờ. Thực tế, nó là một thông điệp.</span>
                    </div>
                </Grid>
                <Grid item xs={4} className="news__list">
                    <img className="news__list-img" alt="tin tức 2" src={tintuc2}></img>
                    <div className="news__list-info">
                        <p className="news__list-title">12 chiếc đồng hồ dành cho nữ giới đắt giá nhất mọi thời đại</p>
                        <span className="news__list-des"> Công nghiệp sản xuất đồng hồ sang trọng có dấu hiệu chững lại trong hai năm gần đây do nhu cầu giảm. Tuy nhiên, có một điểm sáng đó chính là dòng sản phẩm dành cho nữ giới vẫn duy trì được giá trị qua mọi giai đoạn.</span>
                    </div>
                </Grid>
                <Grid item xs={4} className="news__list">
                    <img className="news__list-img" alt="tin tức 1" src={tintuc3}></img>
                    <div className="news__list-info">
                        <p className="news__list-title">10 thương hiệu đồng hồ cao cấp hàng đầu mọi quý ông đều quan tâm, Rolex xếp hạng số 3</p>
                        <span className="news__list-des"> 1. Audemars Piguet

                            Được thành lập vào năm 1875 bởi Jules-Louis Audemars và Edward-Auguste Piguet, Audemars Piguet sản xuất ra 36.000 chiếc đồng hồ mỗi năm. Đây chính là thương hiệu đồng hồ đầu tiên tạo ra chiếc đồng hồ thể thao bằng thép vào năm 1972 (tên là Royal Oak). Sau đó, đến năm 1993, chính thương hiệu Audemars Piguet cũng là người tiên phong trình làng chiếc đồng hồ đeo tay ngoại cỡ đầu tiên có tên Royal Oak Offshore.</span>
                    </div>
                </Grid>
                <Grid item xs={4} className="news__list" >
                    <img className="news__list-img" alt="tin tức 1" src={tintuc4}></img>
                    <div className="news__list-info">
                        <p className="news__list-title">6 chiếc đồng hồ ấn tượng tại Oscar 2019: Từ những thương hiệu đình đám với cái giá “cắt cổ”</p>
                        <span className="news__list-des">Bên cạnh những Cartier, IWC và Jaeger-LeCoultre, có nhiều chiếc đồng hồ thuộc các thương hiệu “độc-lạ” khác được chú ý.</span>
                    </div>
                </Grid>
                <Grid item xs={4} className="news__list" >
                    <img className="news__list-img" alt="tin tức 1" src={tintuc5}></img>
                    <div className="news__list-info">
                        <p className="news__list-title">Casio sẽ ra mắt đồng hồ thông minh thương hiệu G-Shock để cạnh tranh với Apple Watch?</p>
                        <span className="news__list-des"> Có tin Casio dự định trình làng smartwatch G-Shock trong vòng 2 năm tới.</span>
                    </div>
                </Grid>

            </Grid>

        </div>
    );
}
export default News;