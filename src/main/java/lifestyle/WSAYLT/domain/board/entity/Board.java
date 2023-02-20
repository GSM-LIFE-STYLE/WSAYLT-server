package lifestyle.WSAYLT.domain.board.entity;


 import lifestyle.WSAYLT.domain.user.entity.User;
 import lombok.*;
 import org.hibernate.annotations.ColumnDefault;

 import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id", nullable = false)
    private Long boardId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "music_url",nullable = false)
    private String musicUrl;

    @ColumnDefault("0")
    @Column(name = "heart_count", nullable = false)
    private Integer heartCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void updateHeart(Integer heartCount){
        this.heartCount = heartCount;
    }

}
